package respository;

import entity.Booking;
import entity.Show;
import entity.Slot;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {
    private static BookingRepository instance;
    private final Map<Integer, Booking> bookings = new HashMap<>();

    private BookingRepository() {}

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBooking(int bookingId) {
        return bookings.get(bookingId);
    }

    public void removeBooking(int bookingId) {
        bookings.remove(bookingId);
    }

    public List<Booking> getAllBooking(){
        return new ArrayList<>(bookings.values());
    }
}

