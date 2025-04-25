package entity;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;
    private Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots;
    private Map<ParkingSpotType , List<ParkingSpot>> occupiedParkingSpots;

    public ParkingLot(String name, List<EntrancePanel> entrancePanels, List<ExitPanel> exitPanels, Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots, Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots) {
        this.name = name;
        this.entrancePanels = entrancePanels;
        this.exitPanels = exitPanels;
        this.freeParkingSpots = freeParkingSpots;
        this.occupiedParkingSpots = occupiedParkingSpots;
    }

    public ParkingLot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EntrancePanel> getEntrancePanels() {
        return entrancePanels;
    }

    public void setEntrancePanels(List<EntrancePanel> entrancePanels) {
        this.entrancePanels = entrancePanels;
    }

    public List<ExitPanel> getExitPanels() {
        return exitPanels;
    }

    public void setExitPanels(List<ExitPanel> exitPanels) {
        this.exitPanels = exitPanels;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }

    public void setFreeParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> freeParkingSpots) {
        this.freeParkingSpots = freeParkingSpots;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    public void setOccupiedParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> occupiedParkingSpots) {
        this.occupiedParkingSpots = occupiedParkingSpots;
    }
}
