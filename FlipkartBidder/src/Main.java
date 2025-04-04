import entity.Auction;
import entity.Buyer;
import entity.Seller;
import service.AuctionService;
import service.BuyerService;
import service.SellerService;
import service.impl.AuctionServiceImpl;
import service.impl.BuyerServiceImpl;
import service.impl.SellerServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SellerService sellerService = new SellerServiceImpl();
        BuyerService buyerService = new BuyerServiceImpl();
        AuctionService auctionService = new AuctionServiceImpl();

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            input.trim();
            String[] inputArray = input.split(" ");
            switch (inputArray[0]) {
                case ("ADD_BUYER"): {
                    buyerService.addBuyer(new Buyer(UUID.randomUUID().toString(), inputArray[1], null));

                }
                break;
                case ("ADD_SELLER"): {
                    sellerService.addSeller(new Seller(
                            UUID.randomUUID().toString(), inputArray[1], null
                    ));

                }
                break;
                case "CREATE_AUCTION": {
                    auctionService.createAuction(new Auction(
                            UUID.randomUUID().toString(), inputArray[1], null, Integer.parseInt(inputArray[2]),
                            Integer.parseInt(inputArray[3]), Integer.parseInt(inputArray[4]), inputArray[5],
                            null
                    ));

                }
                break;
                case "CREATE_BID": {
                    auctionService.addAndUpdateBid(inputArray[2], inputArray[1], Integer.parseInt(inputArray[3]));

                }
                break;
                case "UPDATE_BID": {
                    auctionService.addAndUpdateBid(inputArray[2], inputArray[1], Integer.parseInt(inputArray[3]));

                }
                break;
                case "CLOSE_AUCTION": {
                    auctionService.getAuctionWinner(inputArray[1]);
                }
                break;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }
}