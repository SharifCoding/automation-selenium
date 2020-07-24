package wikipediaAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class PlacesWikiPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public PlacesWikiPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Wikipedia iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement toolbar = mobiledriver.findElement(Toolbar);
	  	Assert.assertTrue(toolbar.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify the buttons wikipedia and settings on the top.")
	public void check_buttons_wikipedia_and_settings() {
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		System.out.println("Test Status: buttons wikipedia is shown");
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
	  	Assert.assertTrue(button_settings.isDisplayed());
		System.out.println("Test Status: button settings is shown");
	}
	
	@Step ("Click on the Places button, and load the interactive world map.")
	public void click_on_places_button() {
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
	  	button_places.click();
		System.out.println("Test Status: clicked on the places button");
	}
	
	@Step ("Validate category page; Places.")
	public void validate_category_places() {
		MobileElement text_places = mobiledriver.findElement(TextPlaces);
	  	Assert.assertTrue(text_places.isDisplayed());
		MobileElement button_filter = mobiledriver.findElement(ButtonFilter);
	  	Assert.assertTrue(button_filter.isDisplayed());
		MobileElement search_places = mobiledriver.findElement(SearchPlaces);
	  	Assert.assertTrue(search_places.isDisplayed());
		MobileElement show_as_list = mobiledriver.findElement(ShowAsList);
	  	Assert.assertTrue(show_as_list.isDisplayed());
		System.out.println("Test Status: validated places page");
	}
	
	@Step ("Click on the Explore button, and return the home page.")
	public void click_on_explore_button() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
	  	button_explore.click();
		System.out.println("Test Status: clicked on the explore button");
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
	  	Assert.assertTrue(button_settings.isDisplayed());
		System.out.println("Test Status: explore page loaded");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: places test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: places test case completed");
	}
}