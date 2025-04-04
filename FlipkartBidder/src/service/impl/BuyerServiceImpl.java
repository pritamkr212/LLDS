package service.impl;

import entity.Buyer;
import repository.BuyerRepository;
import service.BuyerService;

import java.util.List;
import java.util.Map;

public class BuyerServiceImpl implements BuyerService {
    private Map<String, Buyer> buyerRepository = BuyerRepository.getInstance().getBuyerRepository();

    @Override
    public void addBuyer(Buyer buyer) {
        buyerRepository.put(buyer.getBuyerName(), buyer);
    }

    @Override
    public void removeBuyer(String buyerName) {
        buyerRepository.put(buyerName, null);
    }

    @Override
    public Buyer getBuyer(String buyerName) {
        return buyerRepository.get(buyerName);
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return List.of((Buyer) buyerRepository.values());
    }
}
