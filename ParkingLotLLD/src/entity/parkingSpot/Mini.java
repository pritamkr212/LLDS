package entity.parkingSpot;

public class Mini extends ParkingSpot {
    public Mini(int floor, int amount) {
        super(floor, amount);
    }

    @Override
    public int costing(int parkingHour) {
        return parkingHour * amount;
    }
}
