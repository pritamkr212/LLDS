package entity;

import java.util.List;
import java.util.Objects;

/**
 * The type Buyer.
 */
public class Buyer {
    private String buyerId;
    private String buyerName;
    private List<Auction> buyerauctionList;

    public Buyer(String buyerId, String buyerName, List<Auction> buyerauctionList) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerauctionList = buyerauctionList;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<Auction> getBuyerauctionList() {
        return buyerauctionList;
    }

    public void setBuyerauctionList(List<Auction> buyerauctionList) {
        this.buyerauctionList = buyerauctionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer buyer)) return false;
        return Objects.equals(buyerName, buyer.buyerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buyerName);
    }
}
