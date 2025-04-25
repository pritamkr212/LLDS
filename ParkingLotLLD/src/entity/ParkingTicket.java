package entity;

import entity.parkingSpot.ParkingSpot;
import entity.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger x = new AtomicInteger();
    private int ticketNumber;
    private Vehicle vehicle;
    private LocalDateTime localDateTime;
    private ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, LocalDateTime localDateTime, ParkingSpot parkingSpot) {
        this.ticketNumber = x.incrementAndGet();
        this.vehicle = vehicle;
        this.localDateTime = localDateTime;
        this.parkingSpot = parkingSpot;
    }

    public ParkingTicket() {
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
