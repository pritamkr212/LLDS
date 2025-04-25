package service.impl;

import entity.ParkingLot;
import entity.ParkingTicket;
import entity.parkingSpot.ParkingSpot;
import entity.vehicle.Vehicle;
import enums.ParkingSpotType;
import service.ParkingService;
import strategy.parkingStrategy.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot;

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotType parkingSpotType = vehicle.getParkingSpotType();
        List<ParkingSpot> availableParkingSpot = parkingLot.getFreeParkingSpots().get(parkingSpotType);
        List<ParkingSpot> occupiedParkingSpot = parkingLot.getOccupiedParkingSpots().get(parkingSpotType);
        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotType);
            if(!parkingSpot.isOccupied()){
                synchronized (parkingSpot){
                    parkingSpot.setOccupied(true);
                    occupiedParkingSpot.add(parkingSpot);
                    availableParkingSpot.remove(parkingSpot);
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, LocalDateTime.now(), parkingSpot);
                    return parkingTicket;
                }
            }
        }catch (Exception E){

        }
        return null;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws Exception {
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        if(parkingTicket.getVehicle().getVehicleId() == vehicle.getVehicleId()){
            synchronized (parkingTicket.getParkingSpot()){
                parkingTicket.getParkingSpot().setOccupied(false);
                int amount = parkingSpot.getAmount();
                parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotType()).add(parkingSpot);
                parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotType()).remove(parkingSpot);
                return amount *(LocalDateTime.now().getHour()-parkingTicket.getLocalDateTime().getHour());
            }
        }
        else {
            throw new Exception("Invalid vehicle for this parking ticket");
        }
    }
}
