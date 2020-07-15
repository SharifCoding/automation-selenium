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
		MobileElement button_filter = mobiledriver.findElement(ButtonFilter);
	  	Assert.assertTrue(button_filter.isDisplayed());
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