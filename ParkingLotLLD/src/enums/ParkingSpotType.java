package enums;

import entity.parkingSpot.Compact;
import entity.parkingSpot.Large;
import entity.parkingSpot.Mini;

public enum ParkingSpotType {

    COMPACT(Compact.class),
    LARGE(Large.class),
    MINI(Mini.class);

    private Class parkingSpot;

    ParkingSpotType(Class parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    public Class getParkingSpot() {
        return parkingSpot;
    }
}
