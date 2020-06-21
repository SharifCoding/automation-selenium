package appiumiOSPage;

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
//		System.out.println(mobiledriver.getPageSource());
		mobiledriver.get(mURL);
		System.out.println("Test Status: url loaded: "+ mURL);
	}
		
	@Step ("Check title once Appium home page is loaded.")
	public void check_title_of_page() {
		System.out.println("Test Status: page title \"" + mobiledriver.getTitle() + "\"");
		Assert.assertEquals(mobiledriver.getCurrentUrl(), mURL, "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), mTitle, "Title Mismatch");
	}

	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		mobiledriver.resetApp() ;
		System.out.println("Test Status: appiumHomePage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: appiumHomePage completed");
	}
}