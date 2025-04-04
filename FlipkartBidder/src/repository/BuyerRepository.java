package repository;

import entity.Buyer;

import java.util.HashMap;
import java.util.Map;

public class BuyerRepository {
    private static BuyerRepository instance;  // Singleton instance
    private static Map<String, Buyer> buyerRepository;

    public BuyerRepository() {
        buyerRepository = new HashMap<>();
    }

    public Map<String, Buyer> getBuyerRepository() {
        return buyerRepository;
    }

    public static synchronized BuyerRepository getInstance() {
        if (instance == null) {
            instance = new BuyerRepository();
        }
        return instance;
    }
}
