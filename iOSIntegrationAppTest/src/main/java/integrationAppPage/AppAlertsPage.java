package integrationAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class AppAlertsPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public AppAlertsPage(IOSDriver<IOSElement>mobiledriver) {
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
	
	@Step ("Validate and click on the Scrolling button.")
	public void click_on_the_alerts_button() {
		MobileElement button_alerts = mobiledriver.findElement(ButtonAlerts);
	  	Assert.assertTrue(button_alerts.isDisplayed());
	  	button_alerts.click();
		System.out.println("Test Status: clicked on the alerts button");
	}

	@Step ("Validate the Alerts page with the Navigation bar and the Back button.")
	public void validate_alerts_page() {
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarFBAlertView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
		System.out.println("Test Status: alerts navigation bar is shown");
	}
	
	@Step ("Return and validate the main page.")
	public void return_to_main_page() {
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
	  	button_back.click();
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		System.out.println("Test Status: returned to main page");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: app alerts test is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: app alerts test is completed");
	}
}