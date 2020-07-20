package wikipediaAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class ExploreWikiPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public ExploreWikiPage(IOSDriver<IOSElement>mobiledriver) {
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
	
	@Step ("Verify the Explore tab is shown as active.")
	public void check_explore_tab_active() {
		MobileElement explore_active_button = mobiledriver.findElement(ButtonExploreActive);
	  	Assert.assertTrue(explore_active_button.isDisplayed());
		System.out.println("Test Status: explore is tab active");
	}
	
	@SuppressWarnings("deprecation")
	@Step ("Verify the search field on the Wikipedia app.")
	public void input_and_execute_search_value() {
		MobileElement search_field = mobiledriver.findElement(SearchField);
	  	Assert.assertTrue(search_field.isDisplayed());
	  	search_field.click();
		System.out.println("Test Status: clicked on the search field");
		mobiledriver.getKeyboard().pressKey("Appium");
		System.out.println("Test Status: input and execute a search value");
	}
	
	@Step ("Load the searched value and validate the returned page.")
	public void load_and_verify_searched_page() {
		MobileElement search_return = mobiledriver.findElement(SearchReturn);
	  	Assert.assertTrue(search_return.isDisplayed());
	  	search_return.click();
		System.out.println("Test Status: clicked on a search result");
		MobileElement search_loaded = mobiledriver.findElement(SearchLoaded);
	  	Assert.assertTrue(search_loaded.isDisplayed());
		System.out.println("Test Status: validate loaded search page");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: explore wiki test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: explore wiki test case completed");
	}
}