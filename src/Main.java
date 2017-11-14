import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
	
	static World world;
	
	private static void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your x coordinate (between -10 and 10)");
		
//		String pattern = "\\>\\s?(\\d{1,2})\\,\\s?(\\d{1,2})";
//		String input = scan.next(pattern);
//		
//		System.out.println(input);
		
		int x = scan.nextInt();
		while(true) {
			try {
				if(x < -10 || x > 10) {
					Exception e = new Exception();
					throw e;
				}
				else {
					break;
				}
			}
			catch(Exception e) {
				System.out.println("Please enter a valid x coordinate");
				x = scan.nextInt();
			}
		}
		
		System.out.println("Please enter your y coordinate");
		int y = scan.nextInt();
		while(true) {
			try {
				if(y < -10 || y > 10) {
					Exception e = new Exception();
					throw e;
				}
				else {
					break;
				}
			}
			catch(Exception e) {
				System.out.println("Please enter a valid y coordinate");
				y = scan.nextInt();
			}
		}
		
		scan.close();
		
		System.out.println("Based on your location, here are the 5 closest events, with the cheapest ticket price: ");
		
		ArrayList<Event> nearestEvents = world.findNearestEvents(x, y);
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		

		for (Event event : nearestEvents) {
			Ticket cheapestTicket = event.getCheapestTicket();
			String dfCheapestTicket = df.format(cheapestTicket.getPrice());
			System.out.println("- Event " + event.getID() + ", " + event.getDistance() + " mile(s) away, $" + dfCheapestTicket);
		}
		
	}

	public static void main(String[] args) {
		world = new World();
		userInput();
	}

}
