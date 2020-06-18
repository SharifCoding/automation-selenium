package iOSAppiumPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
 
public class appiumHomePage extends basePage{
    
	//*********Web Page Class Constructor*********
	public appiumHomePage(IOSDriver<WebElement>mobiledriver) {
		basePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Launch Appium home page.")
	public void launch_appium_home_page() {
		mobiledriver.get(basePage.mURL);
		System.out.println("Test Status: url loaded: "+ basePage.mURL);
	}
		
	@Step ("Check title once Appium home page is loaded.")
	public void check_title_of_page() {
		String title = mobiledriver.getTitle();
		System.out.println("Test Status: page title \"" + title + "\"");
		Assert.assertEquals(mobiledriver.getCurrentUrl(), basePage.mURL, "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
	}
	  
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: appiumHomePage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: appiumHomePage completed");
	}
}