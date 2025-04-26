package entity.vehicle;

import enums.ParkingSpotType;

/**
 * The type Car.
 */
public class Car extends Vehicle {
    /**
     * Instantiates a new Car.
     *
     * @param vehicleId the vehicle id
     */
    public Car(int vehicleId) {
        super(vehicleId, ParkingSpotType.COMPACT);
    }
}
