package main.com;

public class AuctionDemo {
	 public static void main(String[] args) {
	       
	        Auctioneer auctioneer = new Auctioneer();

	        
	        Bidder bidder1 = new Bidder("Alice");
	        Bidder bidder2 = new Bidder("Bob");
	        Bidder bidder3 = new Bidder("Charlie");

	        
	        auctioneer.subscribe(bidder1);
	        auctioneer.subscribe(bidder2);
	        auctioneer.subscribe(bidder3);
	        System.out.println();

	       
	        StandardAuction standardAuction = new StandardAuction(auctioneer);
	        System.out.println("=== Standard Auction ===");
	        standardAuction.conductAuction();
	        System.out.println();  

	       
	        ReserveAuction reserveAuction = new ReserveAuction(auctioneer);
	        System.out.println("=== Reserve Auction ===");
	        reserveAuction.conductAuction();
	        System.out.println();  

	        
	        auctioneer.unsubscribe(bidder2);
	        System.out.println();
	    }
}
