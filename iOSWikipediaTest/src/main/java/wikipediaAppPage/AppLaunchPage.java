package wikipediaAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class AppLaunchPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public AppLaunchPage(IOSDriver<IOSElement>mobiledriver) {
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
	
	@Step ("Verify the search field on the Wikipedia app.")
	public void check_search_field() {
		MobileElement search_field = mobiledriver.findElement(SearchField);
	  	Assert.assertTrue(search_field.isDisplayed());
		System.out.println("Test Status: search field is shown");
	}
	
	@Step ("Verify each navigation buttons on the bottom.")
	public void check_navigation_buttons() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
		System.out.println("Test Status: button explore is shown");
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
		System.out.println("Test Status: button places is shown");
		MobileElement button_saved = mobiledriver.findElement(ButtonSaved);
	  	Assert.assertTrue(button_saved.isDisplayed());
		System.out.println("Test Status: button saved is shown");
		MobileElement button_history = mobiledriver.findElement(ButtonHistory);
	  	Assert.assertTrue(button_history.isDisplayed());
		System.out.println("Test Status: button history is shown");
		MobileElement button_search = mobiledriver.findElement(ButtonSearch);
	  	Assert.assertTrue(button_search.isDisplayed());
		System.out.println("Test Status: button search is shown");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: launch app test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: launch app test case completed");
	}
}