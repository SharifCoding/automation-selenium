package appiumiOSPage;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
 
public class appiumNavigatePage extends basePage{
    
	//*********Web Page Class Constructor*********
	public appiumNavigatePage(IOSDriver<WebElement>mobiledriver) {
		basePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Check title once Appium home page is loaded.")
	public void launch_appium_home_page() {
		mobiledriver.get(mURL);
		Assert.assertEquals(mobiledriver.getCurrentUrl(), mURL, "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), mTitle, "Title Mismatch");
	}
	
	@Step ("Appium menu is shown.")
	public void appium_menu_toolbar_is_shown() {
		waitForElement(AppiumNavbar, 30);
		String actualString = mobiledriver.findElement(AppiumNavbar).getText();
		String expectedString = "Appium";
		Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
		System.out.println("Test Status: Appium menu is shown.");
	}
	
	@Step ("Scroll to introducing appium.")
	public void scroll_to_introducing_appium() {
		scrollToElement(IntroducingAppium);
		System.out.println("Test Status: Scrolled to h1 Introducing Appium");
	}
	
	@Step ("Verify the marketing byline.")
	public void verify_marketing_byline() {
		waitForElement(MarketingByline, 30);
		String actualString = mobiledriver.findElement(MarketingByline).getText();
		String expectedString = "Is native app automation missing from your tool belt? Problem solved.";
		Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
		System.out.println("Test Status: Marketing byline verified");
	}
	
	@Step ("Scroll to watch the videos.")
	public void scroll_to_watch_the_videos() {
		scrollToElement(ShowDemoVideo);
		System.out.println("Test Status: Scrolled to h2 Watch the Videos");
	}
	  
	@Step ("Verify each demo video sources.")
	public void verify_demo_videos() {
		waitForElement(WatchVideosButton, 30);
		mobiledriver.findElement(WatchVideosButton).click();
		System.out.println("Test Status: Clicked on Watch Videos");
		checkListAttribute(DemoVideoElements, "src");
		System.out.println("Test Status: Personal project URLs verified");
		array_list.forEach(t -> System.out.println("Test Status: <iframe src=\"" + t + "\">"));
	}
	
	@Step ("Scroll to Appium easy setup process.")
	public void scroll_to_appium_setup() {
		scrollToElement(EasySetupProcess);
		System.out.println("Test Status: Scrolled to h1 Easy Setup Process");
	}
	
	@Step ("Verify the Appium easy setup.")
	public void verify_appium_setup() {
		String actualString = mobiledriver.findElement(EasySetupProcess).getText();
		String expectedString = "Easy setup process, run a test now.";
		Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
		System.out.println("Test Status: Easy setup verified");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		mobiledriver.resetApp() ;
		System.out.println("Test Status: appiumNavigatePage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: appiumNavigatePage completed");
	}
}