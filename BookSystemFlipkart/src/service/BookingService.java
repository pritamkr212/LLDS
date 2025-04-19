package service;

import java.time.LocalDateTime;

/**
 * The interface Booking service.
 */
public interface BookingService {
    /**
     * Book ticket.
     *
     * @param customerName the customer name
     * @param showName     the show name
     * @param startTime    the start time
     * @param personCount  the person count
     */
    void bookTicket(String customerName, String showName, LocalDateTime startTime, int personCount);

    /**
     * Cancel ticket.
     *
     * @param bookingId the booking id
     */
    void cancelTicket(int bookingId);
}
