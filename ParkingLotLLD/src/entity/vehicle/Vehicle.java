package entity.vehicle;

import enums.ParkingSpotType;

/**
 * The type Vehicle.
 */
public abstract class Vehicle {
    private int vehicleId;
    private ParkingSpotType parkingSpotType;

    /**
     * Instantiates a new Vehicle.
     *
     * @param vehicleId       the vehicle id
     * @param parkingSpotType the parking spot type
     */
    public Vehicle(int vehicleId, ParkingSpotType parkingSpotType) {
        this.vehicleId = vehicleId;
        this.parkingSpotType = parkingSpotType;
    }

    /**
     * Gets vehicle id.
     *
     * @return the vehicle id
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets vehicle id.
     *
     * @param vehicleId the vehicle id
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Gets parking spot type.
     *
     * @return the parking spot type
     */
    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    /**
     * Sets parking spot type.
     *
     * @param parkingSpotType the parking spot type
     */
    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
