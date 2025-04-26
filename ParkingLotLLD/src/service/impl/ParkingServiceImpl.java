package service.impl;

import entity.ParkingTicket;
import entity.parkingSpot.ParkingSpot;
import entity.vehicle.Vehicle;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;
import service.ParkingService;
import strategy.parkingStrategy.ParkingStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    private ParkingStrategy parkingStrategy;
    private String parkingLotName;
    private ParkingLotRepository parkingLotRepository;

    public ParkingServiceImpl(ParkingStrategy parkingStrategy, String parkingLotName) {
        this.parkingStrategy = parkingStrategy;
        this.parkingLotName = parkingLotName;
        this.parkingLotRepository = ParkingLotRepository.getInstance(this.parkingLotName);

    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotType parkingSpotType = vehicle.getParkingSpotType();
        List<ParkingSpot> availableParkingSpot = parkingLotRepository.getFreeParkingSpots().get(parkingSpotType);
        List<ParkingSpot> occupiedParkingSpot = parkingLotRepository.getOccupiedParkingSpots().get(parkingSpotType);
        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotType,parkingLotRepository);
            if (!parkingSpot.isOccupied()) {
                synchronized (parkingSpot) {
                    parkingSpot.setOccupied(true);
                    occupiedParkingSpot.add(parkingSpot);
                    availableParkingSpot.remove(parkingSpot);
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, LocalDateTime.now(), parkingSpot);
                    return parkingTicket;
                }
            }
        } catch (Exception E) {

        }
        return null;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws Exception {
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        if (parkingTicket.getVehicle().getVehicleId() == vehicle.getVehicleId()) {
            synchronized (parkingTicket.getParkingSpot()) {
                parkingTicket.getParkingSpot().setOccupied(false);
                int amount = parkingSpot.getAmount();
                parkingLotRepository.getFreeParkingSpots().get(vehicle.getParkingSpotType()).add(parkingSpot);
                parkingLotRepository.getOccupiedParkingSpots().get(vehicle.getParkingSpotType()).remove(parkingSpot);
                return amount * (LocalDateTime.now().getMinute() - parkingTicket.getLocalDateTime().getMinute());
            }
        } else {
            throw new Exception("Invalid vehicle for this parking ticket");
        }
    }
}
