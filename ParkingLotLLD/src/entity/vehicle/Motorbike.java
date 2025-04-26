package entity.vehicle;

import enums.ParkingSpotType;

/**
 * The type Motorbike.
 */
public class Motorbike extends Vehicle {
    /**
     * Instantiates a new Motorbike.
     *
     * @param vehicleId the vehicle id
     */
    public Motorbike(int vehicleId) {
        super(vehicleId, ParkingSpotType.MINI);
    }
}
