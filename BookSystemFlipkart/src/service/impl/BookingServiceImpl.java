package service.impl;

import Utils.Utility;
import entity.Booking;
import entity.Slot;
import entity.User;
import enums.UserType;
import respository.BookingRepository;
import respository.SlotRepository;
import respository.UserRepository;
import service.BookingService;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class BookingServiceImpl implements BookingService {
    private final SlotRepository slotRepository = SlotRepository.getInstance();
    private final BookingRepository bookingRepository = BookingRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    // Global lock for simplicity (can be improved to per-slot locks later)
    private final ReentrantLock lock = new ReentrantLock();

    public BookingServiceImpl() {
        // Run waitlist processor every 2 seconds
        scheduler.scheduleAtFixedRate(this::processAllWaitlists, 1, 5, TimeUnit.SECONDS);
    }

    @Override
    public void bookTicket(String customerName, String showName, LocalDateTime startTime, int personCount) {
        executorService.submit(() -> {
            lock.lock();
            try {
                String slotKey = Utility.generateSlotKey(showName, startTime.toString());
                Slot slot = slotRepository.getSlot(slotKey);
                if (slot == null) {
                    System.out.println("Booking failed: Slot not found for " + showName + " at " + startTime);
                    return;
                }

                User customer = userRepository.getUser(customerName);
                if (customer == null || customer.getUserType() != UserType.CUSTOMER) {
                    System.out.println("Booking failed: Only CUSTOMER can book tickets.");
                    return;
                }

                Booking booking = new Booking(customerName, showName, startTime.toString(), personCount);

                if (slot.getAvailableCapacity() >= personCount) {
                    bookingRepository.addBooking(booking);
                    slot.setAvailableCapacity(slot.getAvailableCapacity() - personCount);
                    System.out.println("Booking successful for Booking ID " + booking.getBookingId() +
                            ": " + customerName + " for show: " + showName + " at " + startTime);
                } else {
                    slot.getWaitlist().offer(booking);
                    System.out.println("Not enough seats. " + customerName + " added to waitlist for " +
                            showName + " at " + startTime);
                }
            } catch (Exception e) {
                System.out.println("Booking failed: " + e.getMessage());
            } finally {
                lock.unlock();
            }
        });
    }

    @Override
    public void cancelTicket(int bookingId) {
        executorService.submit(() -> {
            lock.lock();
            try {
                Booking booking = bookingRepository.getBooking(bookingId);
                if (booking == null) {
                    System.out.println("Cancellation failed: Booking not found!");
                    return;
                }

                String slotKey = Utility.generateSlotKey(booking.getShowName(), booking.getStartTime());
                Slot slot = slotRepository.getSlot(slotKey);
                if (slot == null) {
                    System.out.println("Cancellation failed: Slot not found!");
                    return;
                }

                bookingRepository.removeBooking(bookingId);
                slot.setAvailableCapacity(slot.getAvailableCapacity() + booking.getPersonCount());
                System.out.println("Booking Cancelled Successfully for Booking ID " + bookingId);

            } catch (Exception e) {
                System.out.println("Cancellation failed: " + e.getMessage());
            } finally {
                lock.unlock();
            }
        });
    }

    private void processAllWaitlists() {
        lock.lock();
        try {
            slotRepository.getAllSlots().forEach(slot -> {
                while (!slot.getWaitlist().isEmpty()) {
                    Booking waitlistBooking = slot.getWaitlist().peek();
                    if (waitlistBooking == null) break;

                    if (slot.getAvailableCapacity() >= waitlistBooking.getPersonCount()) {
                        slot.getWaitlist().poll(); // Remove from waitlist
                        slot.setAvailableCapacity(slot.getAvailableCapacity() - waitlistBooking.getPersonCount());
                        bookingRepository.addBooking(waitlistBooking);

                        System.out.println("Booking assigned from waitlist: " +
                                waitlistBooking.getUserName() + " for show " +
                                waitlistBooking.getShowName() + " at " +
                                waitlistBooking.getStartTime());
                    } else {
                        break; // Not enough capacity for next person
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Error while processing waitlists: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
    public static void terminate(){
        executorService.shutdown();
        scheduler.shutdown();
    }
}
