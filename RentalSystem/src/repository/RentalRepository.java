package repository;

import java.util.HashMap;
import java.util.Map;

public class RentalRepository {
    public static Map<String, Object> rentalRepository;

    public RentalRepository() {
        this.rentalRepository = new HashMap<>();

    }

    public static Map<String, Object> getRentalRepository() {
        return rentalRepository;
    }
}
