package entity.vehicle;

import enums.ParkingSpotType;

/**
 * The type Truck.
 */
public class Truck extends Vehicle {
    /**
     * Instantiates a new Truck.
     *
     * @param vehicleId the vehicle id
     */
    public Truck(int vehicleId) {
        super(vehicleId, ParkingSpotType.LARGE);
    }
}
