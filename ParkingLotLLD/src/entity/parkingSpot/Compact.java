package entity.parkingSpot;

public class Compact extends ParkingSpot{
    public Compact(int floor, int amount) {
        super(floor, amount);
    }

    @Override
    public int costing(int parkingHour) {
        return parkingHour * amount;
    }
}
