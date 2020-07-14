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
	
	@Step ("Verify the search field on the Wikipedia app.")
	public void check_search_field() {
		MobileElement search_field = mobiledriver.findElement(SearchFieldSearchWikipedia);
	  	Assert.assertTrue(search_field.isDisplayed());
		System.out.println("Test Status: search field is shown");
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