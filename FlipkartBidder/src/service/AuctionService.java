package service;

import entity.Auction;

import java.util.List;

/**
 * The interface Auction service.
 */
public interface AuctionService {
    /**
     * Create action.
     *
     * @param auction the auction
     */
    void createAuction(Auction auction);

    /**
     * Remove action.
     *
     * @param auction the auction
     */
    void removeAuction(Auction auction);

    /**
     * Gets action.
     *
     * @param auctionName the auction name
     * @return the action
     */
    Auction getAuction(String auctionName);

    /**
     * Gets all actions.
     *
     * @return the all actions
     */
    List<Auction> getAllAuctions();

    /**
     * Add bid.
     *
     * @param auctionName the auction name
     * @param buyerName   the buyer name
     * @param bidAmount   the bid amount
     */
    void addAndUpdateBid(String auctionName, String buyerName, int bidAmount);

    /**
     * Withdraw bid.
     *
     * @param auctionName the auction name
     * @param buyerName   the buyer name
     */
    void withdrawBid(String auctionName, String buyerName);

    /**
     * Auction winner string.
     *
     * @return the string
     */
    Object getAuctionWinner(String actionName);
}
