package strategy.parkingStrategy;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType);
}
