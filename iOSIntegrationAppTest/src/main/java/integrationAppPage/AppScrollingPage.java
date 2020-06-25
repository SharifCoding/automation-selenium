package integrationAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class AppScrollingPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public AppScrollingPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Facebook integration iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement main_view = mobiledriver.findElement(OtherMainView);
	  	Assert.assertTrue(main_view.isDisplayed());
		MobileElement navigation_bar = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Validate the launched Facebook integration iOS app.")
	public void click_on_the_scroll_button() {
		MobileElement button_scrolling = mobiledriver.findElement(ButtonScrolling);
	  	Assert.assertTrue(button_scrolling.isDisplayed());
	  	button_scrolling.click();
		System.out.println("Test Status: clicked on the scrolling button");
	}
	
	@Step ("Validate the launched Facebook integration iOS app.")
	public void validate_scrolling_page() {
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarUIView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		System.out.println("Test Status: scrolling navigation bar is shown");
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
		System.out.println("Test Status: button_back is shown");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: app scrolling test is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		mobiledriver.closeApp();
		System.out.println("Test Status: app scrolling test is completed");
	}
}