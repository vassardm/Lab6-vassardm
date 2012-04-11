import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * DONE A simple class that needs to be localized
 * 
 * @author mohan. Created Mar 27, 2011.
 */
public class PrintBalance {

	/**
	 * Simple Java Method that is crying out to be localized.
	 * 
	 * @param args
	 * @throws ParseException 
	 */

	public static void main(String args[]) throws ParseException {

		// Add in Localization
		ArrayList<String> languageList = new ArrayList<String>();
		ArrayList<String> regionList = new ArrayList<String>();
		languageList.add("en");
		languageList.add("fr");
		languageList.add("de");
		regionList.add("US");
		regionList.add("CA");
		regionList.add("FR");
		regionList.add("DE");

		// Add in Locales
		Locale aLocale = new Locale("en", "US");
		Locale caLocale = new Locale("fr", "CA");
		Locale frLocale = new Locale("fr", "FR");
		Locale deLocale = new Locale("de", "DE");
		
		// Set Locale
		String language = languageList.get(0);
		String country = regionList.get(0);
		Locale currentLocale = new Locale(language, country);

		// Initialize the Resource Bundle
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

		// Initialize the Scanner
		Scanner scanInput = new Scanner(System.in);
		Date today = new Date();
		Number currency = NumberFormat.getInstance().parse((messages.getString("specificAmount")));

		// Greeting
		String hello = messages.getString("hello");
		System.out.println(hello);

		// Get User's Name
		System.out.println(messages.getString("username"));
		String name = scanInput.nextLine();
		System.out.println(messages.getString("greetings") + name);

		// print today's date, balance and bid goodbye
		System.out.println(messages.getString("today")
				+ DateFormat.getDateTimeInstance(DateFormat.FULL,
						DateFormat.FULL, currentLocale).format(today));
		System.out.println(messages.getString("debt")
				+ NumberFormat.getCurrencyInstance(currentLocale).format(currency));
		System.out.println(messages.getString("farewell"));

	}
}
