package service.impl;

import entity.Branch;
import entity.BranchVehicleInfo;
import entity.Vehicle;
import repository.BranchRepository;
import service.BranchService;

import java.util.List;
import java.util.Map;

public class BranchServiceImpl implements BranchService {
    private Map<String, Object> branchRepository = BranchRepository.getBranchRepository();
    @Override
    public void addBranch(Branch branch) {
            branchRepository.put(branch.getBranchName(),branch);
    }

    @Override
    public void updateBranch(String branchName, BranchVehicleInfo branchVehicleInfo) {
        Branch branch = (Branch) branchRepository.get(branchName);
        Map branInfoMap = branch.getVehicleInventory();
        branInfoMap.put(branchVehicleInfo.getVehicle(),branchVehicleInfo);
        branch.setVehicleInventory(branInfoMap);
        branchRepository.put(branchName,branch);

    }

}
