package entity.vehicle;

import enums.ParkingSpotType;

public class Motorbike extends Vehicle {
    public Motorbike(int vehicleId) {
        super(vehicleId, ParkingSpotType.MINI);
    }
}
