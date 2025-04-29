package repository;

import java.util.HashMap;
import java.util.Map;

public class BranchRepository {
    private static Map<String,Object> branchRepository;

    public BranchRepository() {
        this.branchRepository = new HashMap<>();
    }

    public static Map<String, Object> getBranchRepository() {
        return branchRepository;
    }
}
