package Entity;

import java.util.Map;
import java.util.Objects;

public class Seat {
    private String seatId;
    private String seatNo;
    private Boolean isBooked;

    public Seat(String seatId, String seatNo, Boolean isBooked) {
        this.seatId = seatId;
        this.seatNo = seatNo;
        this.isBooked = isBooked;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat seat)) return false;
        return Objects.equals(seatNo, seat.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seatId);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId='" + seatId + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", isBooked=" + isBooked +
                '}';
    }
}
