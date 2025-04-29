package entity;

public class Rent {
    private VehicleType vehicleType;
    private int startTime;
    private int endTime;

    public Rent(VehicleType vehicleType, int startTime, int endTime) {
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
