package entity.parkingSpot;

public class Compact extends ParkingSpot {
    public Compact(int x, int y, int floor, int amount) {
        super(x, y, floor, amount);
    }

    @Override
    public int costing(int parkingCostPerHour) {
        return parkingCostPerHour * amount;
    }
}
