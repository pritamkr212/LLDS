package repository;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String,Object> vehicleRepository ;

    public VehicleRepository() {
        this.vehicleRepository = new HashMap<>();
    }

    public Map<String, Object> getVehicleRepository() {
        return vehicleRepository;
    }
}
