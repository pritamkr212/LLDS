package service.impl;

import entity.Auction;
import repository.AuctionRepository;
import service.AuctionService;

import java.util.*;
import java.util.stream.Collectors;

public class AuctionServiceImpl implements AuctionService {
    private Map<String, Auction> actionMap = AuctionRepository.getInstance().getAuctionRepository();

    @Override
    public void createAuction(Auction auction) {
        actionMap.put(auction.getAuctionName(), auction);
    }

    @Override
    public void removeAuction(Auction auction) {
        actionMap.put(auction.getAuctionName(), auction);
    }

    @Override
    public Auction getAuction(String actionName) {
        return actionMap.get(actionName);
    }

    @Override
    public List<Auction> getAllAuctions() {
        return List.of((Auction) actionMap.values());
    }

    @Override
    public void addAndUpdateBid(String auctionName, String buyerName, int bidAmount) {
        Auction auction = actionMap.get(auctionName);
        if (auction.getAuctionBuyerBidAmounts() == null) {
            auction.setAuctionBuyerBidAmounts(new HashMap<>());
        }
        auction.getAuctionBuyerBidAmounts().put(buyerName, bidAmount);
    }

    @Override
    public void withdrawBid(String auctionName, String buyerName) {
        Auction auction = actionMap.get(auctionName);
        auction.getAuctionBuyerBidAmounts().remove(buyerName);
    }

    @Override
    public Object getAuctionWinner(String auctionName) {
        Auction auction = actionMap.get(auctionName);
        Map<Integer, Boolean> possibleWinner = new HashMap<>();

        for (Map.Entry<String, Integer> it : auction.getAuctionBuyerBidAmounts().entrySet()) {
            int bid = it.getValue();
            possibleWinner.put(bid, !possibleWinner.containsKey(bid));
        }

        Set<Integer> uniqueBids = possibleWinner.entrySet()
                .stream()
                .filter(Map.Entry::getValue) // Keep only entries where value is `true`
                .map(Map.Entry::getKey) // Extract bid amounts
                .collect(Collectors.toSet());
        List<String> winner = new ArrayList<>();
        for (Map.Entry<String, Integer> it : auction.getAuctionBuyerBidAmounts().entrySet()) {
            if (uniqueBids.contains(it.getValue())) {
                winner.add(it.getKey());
            }
        }
        if(winner.isEmpty()||winner.size()>1){
            System.out.println("Winner is Nobody");
        }
        else System.out.println("Winner is "+winner);
        return winner;

    }
}
