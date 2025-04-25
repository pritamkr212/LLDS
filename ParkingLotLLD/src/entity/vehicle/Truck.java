package entity.vehicle;

import enums.ParkingSpotType;

public class Truck extends Vehicle{
    public Truck(int vehicleId) {
        super(vehicleId, ParkingSpotType.LARGE);
    }
}
