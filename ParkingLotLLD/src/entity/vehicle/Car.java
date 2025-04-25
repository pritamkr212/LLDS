package entity.vehicle;

import enums.ParkingSpotType;

public class Car extends Vehicle{
    public Car(int vehicleId) {
        super(vehicleId, ParkingSpotType.COMPACT);
    }
}
