import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * TODO A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2011.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		// Add in Localization
		String language;
		String country;
		Locale aLocale = new Locale("en", "US");
		Locale caLocale = new Locale("fr", "CA");
		Locale frLocale = new Locale("fr", "FR");
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", frLocale);
		
		// Initialize the Scanner
		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();

		// Greeting
		String hello = messages.getString("hello");
		System.out.println(hello);

		// Get User's Name
		System.out.println(messages.getString("username"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("greetings"));

		// print today's date, balance and bid goodbye
		// System.out.println("As of : "+ today.toString());
		System.out.println(messages.getString("today"));
		// System.out.println("You owe the school $9876543.21");
		System.out.println(messages.getString("debt"));
		// System.out.println("Good Bye");
		System.out.println(messages.getString("farewell"));
	
	}
}
