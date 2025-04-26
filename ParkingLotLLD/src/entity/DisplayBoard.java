package entity;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;

import java.util.List;
import java.util.Map;

public class DisplayBoard {
    private String parkingSlotName;
    private Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots;
    private static DisplayBoard instance;

    private DisplayBoard(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
        ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance(parkingSlotName);
        freeParkingSpots = parkingLotRepository.getFreeParkingSpots();
    }

    public static DisplayBoard getInstance(String parkingSlotName) {
        if (instance == null) {
            synchronized (DisplayBoard.class) {
                if (instance == null) { // Double-checked locking
                    return instance = new DisplayBoard(parkingSlotName);
                }
            }
        }
        instance.setFreeParkingSpots(ParkingLotRepository.getInstance(parkingSlotName).getFreeParkingSpots());
        return instance;
    }

    public String getParkingSlotName() {
        return parkingSlotName;
    }

    public void setParkingSlotName(String parkingSlotName) {
        this.parkingSlotName = parkingSlotName;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }
}
