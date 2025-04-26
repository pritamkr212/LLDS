package service;

import entity.ParkingTicket;
import entity.vehicle.Vehicle;

/**
 * The interface Parking service.
 */
public interface ParkingService {
    /**
     * Entry parking ticket.
     *
     * @param vehicle        the vehicle
     * @return the parking ticket
     */
    ParkingTicket entry(Vehicle vehicle);

    /**
     * Exit int.
     *
     * @param parkingTicket  the parking ticket
     * @param vehicle        the vehicle
     * @return the int
     * @throws Exception the exception
     */
    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws Exception;
}
