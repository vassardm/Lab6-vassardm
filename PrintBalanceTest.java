import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.junit.Test;

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
	public void testNoSuchLocaleExistsByIncompatibleRegions() throws MissingResourceException {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(2), regionList.get(0));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertTrue(messages.getString("hello"), true);
	}
	
	@Test
	public void testEnglishLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(0), regionList.get(0));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Hello World", messages.getString("hello"));
	}
	
	@Test
	public void testFrenchLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale(languageList.get(1), regionList.get(1));
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Bonjour tout le monde", messages.getString("hello"));
	}
	
	@Test
	public void testGermanLocaleInitializesHelloWorld() {
		messageBundleComponents();
		Locale currentLocale = new Locale("de", "DE");
		ResourceBundle messages;
		messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
		assertEquals("Hallo Welt", messages.getString("hello"));
	}

}
