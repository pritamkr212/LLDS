package entity.parkingSpot;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private int id;
    private boolean isOccupied;
    private int x;
    private int y;
    private int floor;
    protected int amount;

    public ParkingSpot(int x, int y, int floor, int amount) {
        this.id = counter.incrementAndGet();
        this.isOccupied = false;
        this.floor = floor;
        this.x = x;
        this.y = y;
        this.amount = amount;
    }

    public ParkingSpot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract int costing(int parkingCostPerHour);
}
