package service;

import entity.ParkingTicket;
import entity.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws Exception;
}
