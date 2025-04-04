package repository;

import entity.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerRepository {
    private static SellerRepository instance;
    private static Map<String, Seller> sellerRepository;

    private SellerRepository() {
        sellerRepository = new HashMap<>();
    }

    public static synchronized SellerRepository getInstance() {
        if (SellerRepository.getInstance() == null) {
            instance = new SellerRepository();
        }
        return instance;
    }

    public static Map<String, Seller> getSellerRepository() {
        return sellerRepository;
    }

}
