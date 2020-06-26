package integrationAppPage;

import org.openqa.selenium.ScreenOrientation;
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
	@Step ("Validate the launched Facebook integration iOS app.")
	public void validate_installed_app_via_xcode() {
//		System.out.println(mobiledriver.getPageSource());
		MobileElement main_view = mobiledriver.findElement(OtherMainView);
	  	Assert.assertTrue(main_view.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify the navigation bar on the integration app.")
	public void check_navigation_bar() {
		MobileElement navigation_bar = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar.isDisplayed());
		System.out.println("Test Status: navigation bar is shown");
	}

	@Step ("Verify the integration app buttons.")
	public void check_available_buttons() {
		MobileElement button_alerts = mobiledriver.findElement(ButtonAlerts);
	  	Assert.assertTrue(button_alerts.isDisplayed());
		System.out.println("Test Status: button_alerts is shown");
		MobileElement button_deadlock_app = mobiledriver.findElement(ButtonDeadlock);
	  	Assert.assertTrue(button_deadlock_app.isDisplayed());
		System.out.println("Test Status: button_deadlock_app is shown");
		MobileElement button_attributes = mobiledriver.findElement(ButtonAttributes);
	  	Assert.assertTrue(button_attributes.isDisplayed());
		System.out.println("Test Status: button_attributes is shown");
		MobileElement button_scrolling = mobiledriver.findElement(ButtonScrolling);
	  	Assert.assertTrue(button_scrolling.isDisplayed());
		System.out.println("Test Status: button_scrolling is shown");
	}
	
	@Step ("Verify the expected text depending on the device orientation.")
	public void check_orientation_text() {
		Assert.assertEquals(ScreenOrientation.PORTRAIT, mobiledriver.getOrientation());
		MobileElement text_portrait = mobiledriver.findElement(TextPortrait);
	  	Assert.assertTrue(text_portrait.isDisplayed());
		System.out.println("Test Status: text_portrait is shown");
		mobiledriver.rotate(ScreenOrientation.LANDSCAPE);
		Assert.assertEquals(ScreenOrientation.LANDSCAPE, mobiledriver.getOrientation());
		MobileElement text_landscape = mobiledriver.findElement(TextLandscape);
	  	Assert.assertTrue(text_landscape.isDisplayed());
		System.out.println("Test Status: text_landscape is shown");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: app launch test is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: app launch test is completed");
	}
}