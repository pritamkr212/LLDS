package service;

import entity.Seller;

import java.util.List;

/**
 * The interface Seller service.
 */
public interface SellerService {
    /**
     * Add seller.
     *
     * @param seller the seller
     */
    void addSeller(Seller seller);

    /**
     * Remove seller.
     *
     * @param sellerName the seller name
     */
    void removeSeller(String sellerName);

    /**
     * Gets seller.
     *
     * @param sellerName the seller name
     * @return the seller
     */
    Seller getSeller(String sellerName);

    /**
     * Gets all sellers.
     *
     * @return the all sellers
     */
    List<Seller> getAllSellers();
}
