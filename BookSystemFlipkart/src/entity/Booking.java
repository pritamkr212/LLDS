package entity;

// Booking.java
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
    private static int idCounter = 1;
    private int bookingId;
    private String userName;
    private String showName;
    private String startTime;
    private int personCount;

    public Booking(String userName, String showName, String startTime, int personCount) {
        this.bookingId = idCounter++;
        this.userName = userName;
        this.showName = showName;
        this.startTime = startTime;
        this.personCount = personCount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public String getShowName() {
        return showName;
    }

    public String getStartTime() {
        return startTime;
    }

    public int getPersonCount() {
        return personCount;
    }
}

