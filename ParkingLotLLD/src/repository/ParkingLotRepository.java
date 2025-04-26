package repository;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {
    private static ParkingLotRepository instance;
    private String parkingLotName;
    private Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots;

    private ParkingLotRepository(String parkingLotName) {
        this.parkingLotName = parkingLotName;
        freeParkingSpots = new HashMap<>();
        occupiedParkingSpots = new HashMap<>();
        freeParkingSpots.put(ParkingSpotType.MINI, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotType.COMPACT, new ArrayList<>());
        freeParkingSpots.put(ParkingSpotType.LARGE, new ArrayList<>());

        occupiedParkingSpots.put(ParkingSpotType.MINI, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotType.COMPACT, new ArrayList<>());
        occupiedParkingSpots.put(ParkingSpotType.LARGE, new ArrayList<>());
    }

    public static ParkingLotRepository getInstance(String parkingLotName) {
        if (instance == null) {
            synchronized (ParkingLotRepository.class) {
                if (instance == null) { // Double-checked locking
                    instance = new ParkingLotRepository(parkingLotName);
                }
            }
        }
        return instance;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }
}
