package service;


import entity.parkingSpot.ParkingSpot;
import enums.ParkingSpotType;

import java.lang.reflect.InvocationTargetException;

/**
 * The interface Parking spot service.
 */
public interface ParkingSpotService {
    /**
     * Create spot parking spot.
     *
     * @param parkingSpotType the parking spot type
     * @param parkingLotName  the parking lot name
     * @param x               the x
     * @param y               the y
     * @param floor           the floor
     * @param parkingPrice    the parking price
     * @return the parking spot
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     */
    ParkingSpot createSpot(ParkingSpotType parkingSpotType, String parkingLotName, Integer x, Integer y, Integer floor, Integer parkingPrice)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
