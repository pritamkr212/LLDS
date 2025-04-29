package entity;

import java.util.List;

public class BranchVehicleInfo {
    private double pricePerHour;
    private int quantity;
    private Vehicle vehicle;

    public BranchVehicleInfo(double pricePerHour, int quantity, Vehicle vehicle) {
        this.pricePerHour = pricePerHour;
        this.quantity = quantity;
        this.vehicle = vehicle;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
