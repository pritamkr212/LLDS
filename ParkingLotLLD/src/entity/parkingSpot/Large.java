package entity.parkingSpot;

public class Large extends ParkingSpot {
    public Large(int x, int y, int floor, int amount) {
        super(x, y, floor, amount);
    }

    @Override
    public int costing(int parkingCostPerHour) {
        return parkingCostPerHour * amount;
    }
}
