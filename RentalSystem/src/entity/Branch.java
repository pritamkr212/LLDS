package entity;

import java.util.Map;

public class Branch {
    private String branchName;
    private Map<Vehicle, BranchVehicleInfo> vehicleInventory;

    public Branch(String branchName, Map<Vehicle, BranchVehicleInfo> vehicleInventory) {
        this.branchName = branchName;
        this.vehicleInventory = vehicleInventory;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Map<Vehicle, BranchVehicleInfo> getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(Map<Vehicle, BranchVehicleInfo> vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }
}
