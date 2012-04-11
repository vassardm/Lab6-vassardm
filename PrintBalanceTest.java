import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.junit.Test;

import com.sun.org.apache.xml.internal.security.signature.MissingResourceFailureException;

public class PrintBalanceTest {

	ArrayList<String> languageList = new ArrayList<String>();
	ArrayList<String> regionList = new ArrayList<String>();

	public void messageBundleComponents() {
		// Add in Localization
		languageList.add("en");
		languageList.add("fr");
		languageList.add("de");
		regionList.add("US");
		regionList.add("FR");
		regionList.add("DE");
	}

	@Test
	public void printBalanceTestIsWorking() {
		assertTrue("I am working! Yay!", true);
	}

	@Test
	public void testNoSuchLocaleExists() throws MissingResourceException {
		messageBundleComponents();
		Locale currentLocale = new Locale("jp", "JP");
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertTrue(messages.getString("hello"), true);
	}

	@Test
	public void testNoSuchLocaleExistsByIncompatibleRegions()
			throws MissingResourceException {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(2), regionList
				.get(0));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertTrue(messages.getString("hello"), true);
	}

	@Test
	public void testNoSuchLocaleExistsByMissingKeys()
			throws MissingResourceException {
		messageBundleComponents();
		try{
			Locale currentLocale = new Locale(languageList.get(0), regionList
					.get(0));
			ResourceBundle messages;
			messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
			messages.getString("herp");
			fail(); // Exception not thrown
		}
		catch(MissingResourceException e){
			// Passed the test
		}
	}

	@Test
	public void testEnglishLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(0), regionList
				.get(0));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Hello World", messages.getString("hello"));
	}

	@Test
	public void testFrenchLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(1), regionList
				.get(1));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Bonjour tout le monde", messages.getString("hello"));
	}

	@Test
	public void testGermanLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(2), regionList
				.get(2));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Hallo Welt", messages.getString("hello"));
	}

	@Test
	public void testEnglishLocaleFormatsCorrectDate() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(0), regionList
				.get(0));
		Date today = new Date();
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals(DateFormat.getDateTimeInstance().format(today), DateFormat
				.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT,
						currentLocale).format(today));
	}

	@Test
	public void testFrenchLocaleFormatsCorrectDate() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(1), regionList
				.get(1));
		Date today = new Date();
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals(DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
				DateFormat.DEFAULT, currentLocale).format(today), DateFormat
				.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT,
						currentLocale).format(today));
	}

	@Test
	public void testGermanLocaleFormatsCorrectDate() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(2), regionList
				.get(2));
		Date today = new Date();
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals(DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
				DateFormat.DEFAULT, currentLocale).format(today), DateFormat
				.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT,
						currentLocale).format(today));
	}

	@Test
	public void testEnglishLocaleFormatsCorrectCurrency() throws ParseException {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(0), regionList
				.get(0));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		Number currency = NumberFormat.getInstance().parse(
				(messages.getString("specificAmount")));
		assertEquals("$9,876,432.21", NumberFormat.getCurrencyInstance(currentLocale).format(currency));
	}

	@Test
	public void testFrenchLocaleFormatsCorrectCurrency() throws ParseException {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(1), regionList
				.get(1));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		Number currency = NumberFormat.getInstance().parse(
				(messages.getString("specificAmount")));
		assertEquals("9 876 432,21 €", NumberFormat.getCurrencyInstance(currentLocale).format(currency));
	}

	@Test
	public void testGermanLocaleFormatsCorrectCurrency() throws ParseException {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(2), regionList
				.get(2));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		Number currency = NumberFormat.getInstance().parse(
				(messages.getString("specificAmount")));
		assertEquals("9.876.432,21 €", NumberFormat.getCurrencyInstance(currentLocale).format(currency));
	}
}
