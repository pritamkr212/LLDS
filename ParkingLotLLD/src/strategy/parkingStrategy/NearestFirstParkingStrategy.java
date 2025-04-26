package strategy.parkingStrategy;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestFirstParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotType parkingSpotType, ParkingLotRepository parkingLotRepository) {
        List<ParkingSpot> availableParkingSpots = parkingLotRepository.getFreeParkingSpots().get(parkingSpotType);
        if (availableParkingSpots.isEmpty()) {
            throw new RuntimeException("No available parking spots for the given parking spot type");
        }
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((spot1, spot2) -> {
            if (spot1.getFloor() != spot2.getFloor()) {
                return Integer.compare(spot1.getFloor(), spot2.getFloor());
            }
            int distance1 = spot1.getX() * spot1.getX() + spot1.getY() * spot1.getY();
            int distance2 = spot2.getX() * spot2.getX() + spot2.getY() * spot2.getY();
            return Integer.compare(distance1, distance2);
        });

        pq.addAll(availableParkingSpots);

        return pq.poll();
    }
}

