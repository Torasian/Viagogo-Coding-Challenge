/*
 * The ticket class creates tickets and initialises them with a price.
 * 
 * @author William
 */
public class Ticket {
	
	private double ticketPrice;
	
	/**
	 * Constructor that initalises the ticket price
	 * @param ticketPrice - the price in US dollars.
	 */
	public Ticket(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	/*
	 * An accessor method to get the price of a ticket
	 */
	public double getPrice() {
		return ticketPrice;
	}

}
