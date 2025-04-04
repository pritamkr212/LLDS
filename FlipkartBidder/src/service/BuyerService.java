package service;

import entity.Buyer;
import entity.Seller;

import java.util.List;

/**
 * The interface Buyer service.
 */
public interface BuyerService {
    /**
     * Add seller.
     *
     * @param buyer the buyer
     */
    void addBuyer(Buyer buyer);

    /**
     * Remove seller.
     *
     * @param buyerName the buyer name
     */
    void removeBuyer(String buyerName);

    /**
     * Gets seller.
     *
     * @param buyerNane the buyer nane
     * @return the seller
     */
    Buyer getBuyer(String buyerNane);

    /**
     * Gets all sellers.
     *
     * @return the all sellers
     */
    List<Buyer> getAllBuyer();
}
