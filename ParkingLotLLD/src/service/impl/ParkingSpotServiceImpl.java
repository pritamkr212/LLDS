package service.impl;

import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;
import service.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    @Override
    public ParkingSpot createSpot(ParkingSpotType parkingSpotType, Integer floor, Integer amount)  {
        try {
            ParkingSpot parkingSpot= (ParkingSpot) parkingSpotType.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpot).add(parkingSpot);
            displayService.update(parkingSpotEnum,1);
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
