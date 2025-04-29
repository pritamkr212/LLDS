package service;

import entity.Branch;
import entity.Vehicle;

public interface RentalService {
    void addRental(Vehicle vehicle, int startTime, int endTime);
}
