package service;

import entity.Branch;
import entity.BranchVehicleInfo;
import entity.Vehicle;

import java.util.List;

public interface BranchService {
    void addBranch(Branch branches);
    void updateBranch(String branchName, BranchVehicleInfo branchVehicleInfo);
}
