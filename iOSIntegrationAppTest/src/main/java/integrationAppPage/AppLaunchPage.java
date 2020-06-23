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
	public void launch_already_installed_app() {
		System.out.println(mobiledriver.getPageSource());
		MobileElement display = mobiledriver.findElementByXPath("//XCUIElementTypeOther[@name=\"MainView\"]");
	  	Assert.assertTrue(display.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify the integration app buttons on launch.")
	public void check_the_available_buttons() {
		MobileElement display = mobiledriver.findElementByXPath("//XCUIElementTypeNavigationBar[@name=\"View\"]");
	  	Assert.assertTrue(display.isDisplayed());
		System.out.println("Test Status: navigation bar is shown");
		MobileElement button_alerts = mobiledriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Alerts\"]");
	  	Assert.assertTrue(button_alerts.isDisplayed());
		System.out.println("Test Status: button_alerts is shown");
		MobileElement button_deadlock_app = mobiledriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Deadlock app\"]");
	  	Assert.assertTrue(button_deadlock_app.isDisplayed());
		System.out.println("Test Status: button_deadlock_app is shown");
		MobileElement button_attributes = mobiledriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Attributes\"]");
	  	Assert.assertTrue(button_attributes.isDisplayed());
		System.out.println("Test Status: button_attributes is shown");
		MobileElement button_scrolling = mobiledriver.findElementByXPath("//XCUIElementTypeButton[@name=\"Scrolling\"]");
	  	Assert.assertTrue(button_scrolling.isDisplayed());
		System.out.println("Test Status: button_scrolling is shown");
		MobileElement text_portrait = mobiledriver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Portrait\"]");
	  	Assert.assertTrue(text_portrait.isDisplayed());
		System.out.println("Test Status: text_portrait is shown");
	}

	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		mobiledriver.resetApp() ;
		System.out.println("Test Status: AppLaunchPage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: AppLaunchPage completed");
	}
}