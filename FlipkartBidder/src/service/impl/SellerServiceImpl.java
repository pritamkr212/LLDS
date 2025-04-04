package service.impl;

import entity.Buyer;
import entity.Seller;
import repository.BuyerRepository;
import repository.SellerRepository;
import service.SellerService;

import java.util.List;
import java.util.Map;

public class SellerServiceImpl implements SellerService {

    private Map<String, Seller> sellerRepository = SellerRepository.getSellerRepository();
    @Override
    public void addSeller(Seller seller) {
        sellerRepository.put(seller.getSellerName(),seller);
    }

    @Override
    public void removeSeller(String sellerId) {
        sellerRepository.put(sellerId,null);
    }

    @Override
    public Seller getSeller(String sellerName) {
        return sellerRepository.get(sellerName);
    }

    @Override
    public List<Seller> getAllSellers() {
        return List.of((Seller) SellerRepository.getSellerRepository().values());
    }
}
