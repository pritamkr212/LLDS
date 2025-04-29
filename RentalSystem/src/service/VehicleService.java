package service;

import entity.Vehicle;

/**
 * The interface Vehicle service.
 */
public interface VehicleService {
    /**
     * Add vehicle.
     *
     * @param vehicleId the vehicle id
     * @param vehicle   the vehicle
     */
    void addVehicle(String vehicleId, Vehicle vehicle);

    /**
     * Remove vehicle.
     *
     * @param vehicleId the vehicle id
     */
    void removeVehicle(String vehicleId);

    /**
     * Update vehicle.
     *
     * @param vehicleId the vehicle id
     * @param vehicle   the vehicle
     */
    void updateVehicle(String vehicleId, Vehicle vehicle);
}
