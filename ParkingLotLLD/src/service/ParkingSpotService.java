package service;


import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;

import java.lang.reflect.InvocationTargetException;

public interface ParkingSpotService {
    ParkingSpot createSpot(ParkingSpotType parkingSpotType, Integer floor, Integer amount) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
