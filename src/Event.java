/*
 * The Event class is responsible for creating tickets and 
 * initialising them with an eventID, location, some number of tickets 
 * and the distance away from the user.
 * 
 * It provides the functionality to mutate and access some of the variables.
 * 
 * @author William
 */
public class Event {
	
	private int eventID;
	private int distanceToUser;
	private int[] location;
	private Ticket[] tickets;
	
	/**
	 * Constructor to initialise an event
	 * @param eventID - an ID to identify each event from one another
	 * @param tickets - an array of tickets associated with the event.
	 */
	public Event(int eventID, Ticket[] tickets) {
		this.eventID = eventID;
		this.tickets = tickets;
	}
	
	/**
	 * Finds the cheapest ticket for a given event
	 * @return - returns a Ticket
	 */
	public Ticket getCheapestTicket() {
		
		double currentTicketPrice = tickets[0].getPrice();
		int currentIndex = 0;
		
		/*
		 * loops through the Ticket array and each time it finds a lower price,
		 * it sets the current ticket ticket price to the new ticket price
		 */
		for (int i = 1; i < tickets.length; i++) {
			double newTicketPrice = tickets[i].getPrice();
			if (newTicketPrice < currentTicketPrice) {
				currentTicketPrice = newTicketPrice;
				currentIndex = i;
			}
		}
		return tickets[currentIndex];
	}
	
    /*
     * An accessor method to get the location for a given event.
     */
	public int[] getLocation() {
		return location;
	}
	
	/*
	 * A mutator method to set the location for events. 
	 * It takes an array of locations as its input.
	 */
	public void setLocation(int[] location) {
		this.location = location;
	}
	
	/*
     * An accessor method to get the distance from the user to the event\.
     */
	public int getDistance() {
		return distanceToUser;
	}
	
	/*
     * A mutator method to set the distance from a user to an event.
     */
	public void setDistance(int distanceToUser) {
		this.distanceToUser = distanceToUser;
	}
	
	/*
     * An accessor method to get the eventID for a given event.
     */
	public int getID() {
		return eventID;
	}
	
	/*
     * An accessor method to get the tickets array.
     */
	public Ticket[] getTickets() {
		return tickets;
	}
}
