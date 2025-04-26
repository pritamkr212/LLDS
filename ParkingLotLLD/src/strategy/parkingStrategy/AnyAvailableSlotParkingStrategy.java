package strategy.parkingStrategy;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;

import java.util.List;

public class AnyAvailableSlotParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType, ParkingLotRepository parkingLotRepository) {
        List<ParkingSpot> availableParkingSpots = parkingLotRepository.getFreeParkingSpots().get(parkingSpotType);
        if (availableParkingSpots.isEmpty()) {
            throw new RuntimeException("No available parking spots for the given parking spot type");
        }
        return availableParkingSpots.get(0);
    }
}
