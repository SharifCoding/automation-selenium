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
	
	@Step ("Click on the settings button, scroll down to the About the app option, and then click.")
	public void navigate_to_about_app_via_settings() {
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
		button_settings.click();
		System.out.println("Test Status: clicked on the settings button");
		MobileElement text_settings = mobiledriver.findElement(TextSettings);
	  	Assert.assertTrue(text_settings.isDisplayed());
		System.out.println("Test Status: text settings is shown");
		scrollToElement(TextAboutTheApp);
		MobileElement about_app_by_id = mobiledriver.findElementByAccessibilityId("About the app");
		about_app_by_id.click();
	}
	
	@Step ("Click on cross butoon to close the settings page.")
	public void validate_app_version() {
		MobileElement button_about = mobiledriver.findElement(ButtonAbout);
	  	Assert.assertTrue(button_about.isDisplayed());
	  	button_about.click();
		System.out.println("Test Status: clicked on the about button");
	}
	
	@Step ("Click on cross butoon to close the settings page.")
	public void close_the_settings_page() {
		MobileElement button_close = mobiledriver.findElement(ButtonClose);
	  	Assert.assertTrue(button_close.isDisplayed());
	  	button_close.click();
		System.out.println("Test Status: clicked on the closed button");
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
	  	Assert.assertTrue(button_settings.isDisplayed());
		System.out.println("Test Status: settings page is closed");
	}
	
	@Step ("Verify the Explore tab is shown as active.")
	public void check_explore_tab_active() {
		MobileElement explore_active_button = mobiledriver.findElement(ButtonExploreActive);
	  	Assert.assertTrue(explore_active_button.isDisplayed());
		System.out.println("Test Status: explore is tab active");
	}
	
	@Step ("Verify the search field on the Wikipedia app.")
	public void input_and_execute_search_value() {
		MobileElement search_field = mobiledriver.findElement(SearchField);
	  	Assert.assertTrue(search_field.isDisplayed());
	  	search_field.click();
		System.out.println("Test Status: clicked on the search field");
		MobileElement search_field_by_id = mobiledriver.findElementByAccessibilityId("Search Wikipedia");
		search_field_by_id.sendKeys(mSearchString);
		System.out.println("Test Status: input and execute search value: " + mSearchString);
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