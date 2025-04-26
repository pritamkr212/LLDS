package service.impl;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import repository.ParkingLotRepository;
import service.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServiceImpl implements ParkingSpotService {

    @Override
    public ParkingSpot createSpot(ParkingSpotType parkingSpotType, String parkingLotName, Integer x, Integer y, Integer floor, Integer parkingPrice) {
        try {
            ParkingLotRepository parkingLotRepository = ParkingLotRepository.getInstance(parkingLotName);
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotType.getParkingSpot()
                    .getConstructor(int.class, int.class, int.class, int.class).newInstance(x, y, floor, parkingPrice);
            parkingLotRepository.getFreeParkingSpots().get(parkingSpotType).add(parkingSpot);
            return parkingSpot;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
