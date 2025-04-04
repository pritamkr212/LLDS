package entity;

import java.util.List;
import java.util.Objects;

/**
 * The type Seller.
 */
public class Seller {
    private String sellerId;
    private String sellerName;
    private List<Auction> sellerAuctionList;

    public Seller(String sellerId, String sellerName, List<Auction> sellerAuctionList) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerAuctionList = sellerAuctionList;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<Auction> getSellerAuctionList() {
        return sellerAuctionList;
    }

    public void setSellerAuctionList(List<Auction> sellerAuctionList) {
        this.sellerAuctionList = sellerAuctionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller seller)) return false;
        return Objects.equals(sellerName, seller.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sellerName);
    }
}
