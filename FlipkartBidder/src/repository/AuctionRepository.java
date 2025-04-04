package repository;

import entity.Auction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AuctionRepository {
    private static AuctionRepository instance;  // Singleton instance
    private final Map<String, Auction> auctionRepository; // Instance variable

    private AuctionRepository() {
        auctionRepository = new HashMap<>();
    }

    public static synchronized AuctionRepository getInstance() {
        if (instance == null) {
            instance = new AuctionRepository();
        }
        return instance;
    }


    public Map<String, Auction> getAuctionRepository() {
        return auctionRepository;
    }
}
