package entity.parkingSpot;

public class Large extends ParkingSpot {
    public Large(int floor, int amount) {
        super(floor, amount);
    }

    @Override
    public int costing(int parkingHour) {
        return parkingHour * amount;
    }
}
