package strategy.parkingStrategy;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType, ParkingLotRepository parkingLotRepository);
}
