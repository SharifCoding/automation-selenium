package integrationAppPage;

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
	@Step ("Launch the facebook integration iOS app.")
	public void launch_app_installed_via_xcode() {
//		System.out.println(mobiledriver.getPageSource());
		MobileElement main_view = mobiledriver.findElement(OtherMainView);
	  	Assert.assertTrue(main_view.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify the integration app buttons on launch.")
	public void check_navigation_bar() {
		MobileElement navigation_bar = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar.isDisplayed());
		System.out.println("Test Status: navigation bar is shown");
	}

	@Step ("Verify the integration app buttons on launch.")
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
	
	@Step ("Verify the integration app buttons on launch.")
	public void check_text_portrait() {
		MobileElement text_portrait = mobiledriver.findElement(TextPortrait);
	  	Assert.assertTrue(text_portrait.isDisplayed());
		System.out.println("Test Status: text_portrait is shown");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: AppLaunchPage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: AppLaunchPage completed");
	}
}