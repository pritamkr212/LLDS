package entity.vehicle;

import enums.ParkingSpotType;

public  abstract class Vehicle {
    private int vehicleId;
    private ParkingSpotType parkingSpotType;

    public Vehicle(int vehicleId, ParkingSpotType parkingSpotType) {
        this.vehicleId = vehicleId;
        this.parkingSpotType = parkingSpotType;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}
