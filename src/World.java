import java.util.ArrayList;

/*
 * The World class generates a world ranging between the coordinate -10 and 10. 
 * It also generates a random number of events, assigning them a set number of tickets
 * and a location. 
 * 
 * @author William 
 */

public class World {

	private ArrayList<int[]> coordinates;
	private ArrayList<Event> events;

	/*
	 * A constructor that calls generateWorld() and generateEvents()
	 */
	public World() {
		generateWorld();
		generateEvents();
	}
	
	/*
	 * This method creates a world of size -10 to 10 in x and y directions.
	 * @return - the method returns an ArrayList containing an integer array of coordinates
	 */
	private ArrayList<int[]> generateWorld() {
		coordinates = new ArrayList<int[]>();
		
		/*
		 * The loop, loops through -10 to 10 for both sets of axis and adds
		 * the coordinates to the array coordinate
		 */
		for (int x = -10; x <= 10; x++) {
			for (int y = -10; y <= 10; y++) {
				int[] coordinate = {x, y};
				coordinates.add(coordinate);
			}
		}
		
		return coordinates;
	}
	
	/*
	 * This method generates and ArrayList of events
	 */
	private void generateEvents() {
		//we generate a random number of events between 5 and 400
		int numberOfEvents = (int) (Math.random() * 395) + 5;
		System.out.println(numberOfEvents);
		
		events = new ArrayList<>();
		
		/*
		 * In this loop, we loop through the events ArrayList 
		 * and create a number of tickets which we then store in a Ticket array.
		 */
		for (int i = 1; i <= numberOfEvents; i++) {
			//we create a random number of ticket between 0 and 5
			int numberOfTickets = (int) (Math.random() * 5);
			
			//to avoid having 0 tickets for an event, we use this if conidtion to make sure
			//we have at least 1 ticket.
			if(i < 6) {
				numberOfTickets = (int) (Math.random()*5) + 1;
			}
			
			Ticket[] tickets = generateTickets(numberOfTickets);
			
			Event event = new Event(i, tickets);
			events.add(event);
		}
		
		assignLocations(events);
	}

	/**
	 * This method creates an array of tickets based on the number of tickets created in generate events.
	 * It assigns each ticket a price.
	 * @param numberOfTickets - number of tickets as decided in generateEvent()
	 * @return - An array of tickets
	 */
	private Ticket[] generateTickets(int numberOfTickets) {
		Ticket[] tickets = new Ticket[numberOfTickets];
		
		/*
		 * This loop assigns each ticket a price between $1 and $150
		 */
		for (int i = 0; i < tickets.length; i++) {
			double ticketPrice = (Math.random() * 149) + 1 ;
			Ticket ticket = new Ticket(ticketPrice);
			tickets[i] = ticket;
		}
		
		return tickets;
	}
	
	/*
	 * This method assigns each event in the ArrayList of events a location.
	 */
	private void assignLocations(ArrayList<Event> events) {
		/*
		 * We loop through 'events' and assign each event a random coordinate
		 * Each time we remove the coordinate we have assigned, so that no two events are in the same location.
		 */
		for (int i = 0; i < events.size(); i++) {
			ArrayList<int[]> coordinates = this.coordinates;
			int locationIndex = (int) (Math.random()*coordinates.size());
			events.get(i).setLocation(coordinates.remove(locationIndex));
		}
	}
	
	/*
	 * This method find the nearest events, given the users location.
	 * @param x - the x coordinate of the user 
	 * @param y - the y coordinate of the user
	 */
	public ArrayList<Event> findNearestEvents(int x, int y) {
		calculateDistances(x, y);
		ArrayList<Event> nearestEvents = new ArrayList<>();
		
		//while there is no more than 5 events in the nearestEvents array
		while (nearestEvents.size() < 5) {
			int currentDistance = events.get(0).getDistance();
			int currentIndex = 0;
			/* 
			 * We loop through the events array and get the distance from the user
			 * When we find a distance less than the currentDistance, we add the event to nearest events when
			 * we are sure it is the nearest event, we then remove it from the events arraylist so that it is not
			 * selected more than one time.
			 */
			
			for (int j = 1; j < events.size(); j++) {
				int newDistance = events.get(j).getDistance();
				if(newDistance < currentDistance) {
					currentDistance = newDistance;
					currentIndex = j;
				}
			}
			if (events.get(currentIndex).getTickets().length > 0) {
				nearestEvents.add(events.remove(currentIndex));
			}
			else {
				events.remove(currentIndex);
			}
		}
		
		return nearestEvents;
	}
	
	/*
	 * This method calculates the Manhattan distance between two coordinates
	 * @param x1 - the x coordinate of the user
	 * @param y1 - the u coordinate of the user
	 */
	private void calculateDistances(int x1, int y1) {
		for (Event event : events) {
			int x2 = event.getLocation()[0];
			int y2 = event.getLocation()[1];
			
			int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
			event.setDistance(distance);
		}
	}
	
	/*
	 * An accessor method to get the coordinates
	 */
	public ArrayList<int[]> getCoordinates() {
		return coordinates;
	}
}
