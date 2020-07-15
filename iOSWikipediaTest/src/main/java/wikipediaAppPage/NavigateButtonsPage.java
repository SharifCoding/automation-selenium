package wikipediaAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class NavigateButtonsPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public NavigateButtonsPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Wikipedia iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement toolbar = mobiledriver.findElement(Toolbar);
	  	Assert.assertTrue(toolbar.isDisplayed());
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
	  	Assert.assertTrue(button_settings.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify each navigation buttons on the bottom.")
	public void check_navigation_buttons() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
		MobileElement button_saved = mobiledriver.findElement(ButtonSaved);
	  	Assert.assertTrue(button_saved.isDisplayed());
		MobileElement button_history = mobiledriver.findElement(ButtonHistory);
	  	Assert.assertTrue(button_history.isDisplayed());
		MobileElement button_search = mobiledriver.findElement(ButtonSearch);
	  	Assert.assertTrue(button_search.isDisplayed());
		System.out.println("Test Status: navigation buttons are shown");
	}
	
	@Step ("Click on the navigation button; Places.")
	public void click_on_button_places() {
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
	  	button_places.click();
		System.out.println("Test Status: places button clicked");
		MobileElement text_places = mobiledriver.findElement(TextPlaces);
	  	Assert.assertTrue(text_places.isDisplayed());
		MobileElement button_filter = mobiledriver.findElement(ButtonFilter);
	  	Assert.assertTrue(button_filter.isDisplayed());
	}
	
	@Step ("Click on the navigation button; Saved.")
	public void click_on_button_saved() {
		MobileElement button_saved = mobiledriver.findElement(ButtonSaved);
	  	Assert.assertTrue(button_saved.isDisplayed());
	  	button_saved.click();
		System.out.println("Test Status: saved button clicked");
		MobileElement text_saved = mobiledriver.findElement(TextSaved);
	  	Assert.assertTrue(text_saved.isDisplayed());
		System.out.println("Test Status: saved page verified");
	}
	
	@Step ("Click on the navigation button; History.")
	public void click_on_button_history() {
		MobileElement button_history = mobiledriver.findElement(ButtonHistory);
	  	Assert.assertTrue(button_history.isDisplayed());
	  	button_history.click();
		System.out.println("Test Status: history button clicked");
		MobileElement text_history = mobiledriver.findElement(TextHistory);
	  	Assert.assertTrue(text_history.isDisplayed());
		System.out.println("Test Status: history page verified");
	}
	
	@Step ("Click on the navigation button; Search.")
	public void click_on_button_search() {
		MobileElement button_search = mobiledriver.findElement(ButtonSearch);
	  	Assert.assertTrue(button_search.isDisplayed());
	  	button_search.click();
		System.out.println("Test Status: search button clicked");
		MobileElement text_search = mobiledriver.findElement(TextSearch);
	  	Assert.assertTrue(text_search.isDisplayed());
		System.out.println("Test Status: search page verified");
	}
	
	@Step ("Click on the navigation button; Explore.")
	public void click_on_button_explore() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
	  	button_explore.click();
		System.out.println("Test Status: explore button clicked");
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		System.out.println("Test Status: explore page verified");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: navigation buttons test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: navigation buttons test case completed");
	}
}