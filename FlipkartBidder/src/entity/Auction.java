package entity;

import java.util.Map;
import java.util.Objects;

/**
 * The type Auction.
 */
public class Auction {
    private String auctionId;
    private String auctionName;
    private String sellerName;
    private String BuyerName;
    private int minBidAmount;
    private int maxBidAmount;
    private int depositBidAmount;
    private Map<String, Integer> auctionBuyerBidAmounts;

    public Auction(String auctionId, String auctionName, String buyerName, int minBidAmount,
                   int maxBidAmount, int depositBidAmount, String sellerName, Map<String, Integer> auctionBuyerBidAmounts) {
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.sellerName = sellerName;
        BuyerName = buyerName;
        this.minBidAmount = minBidAmount;
        this.maxBidAmount = maxBidAmount;
        this.depositBidAmount = depositBidAmount;
        this.auctionBuyerBidAmounts = auctionBuyerBidAmounts;
    }


    public String getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public String getAuctionName() {
        return auctionName;
    }

    public void setAuctionName(String auctionName) {
        auctionName = auctionName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        sellerName = sellerName;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }

    public int getMinBidAmount() {
        return minBidAmount;
    }

    public void setMinBidAmount(int minBidAmount) {
        this.minBidAmount = minBidAmount;
    }

    public int getMaxBidAmount() {
        return maxBidAmount;
    }

    public void setMaxBidAmount(int maxBidAmount) {
        this.maxBidAmount = maxBidAmount;
    }

    public int getDepositBidAmount() {
        return depositBidAmount;
    }

    public void setDepositBidAmount(int depositBidAmount) {
        this.depositBidAmount = depositBidAmount;
    }

    public Map<String, Integer> getAuctionBuyerBidAmounts() {
        return auctionBuyerBidAmounts;
    }

    public void setAuctionBuyerBidAmounts(Map<String, Integer> auctionBuyerBidAmounts) {
        this.auctionBuyerBidAmounts = auctionBuyerBidAmounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auction auction)) return false;
        return Objects.equals(auctionName, auction.auctionName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(auctionName);
    }
}
