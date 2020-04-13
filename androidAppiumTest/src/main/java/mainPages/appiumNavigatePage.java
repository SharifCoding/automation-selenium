package mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class appiumNavigatePage extends basePage{
 
  //*********Web Elements*********
  By AppiumNavbar = By.className("navbar-brand");
  By IntroducingAppium = By.id("introducing-appium");
  By WatchVideosButton = By.xpath("//*[contains(text(), 'Watch the Videos')]");
  By ShowDemoVideo = By.id("show-demo-video");
  By EasySetupProcess = By.xpath("//*[contains(text(), 'Easy setup process, run a test now.')]");
    
  //*********Web Page Class Constructor*********
  public appiumNavigatePage(AndroidDriver<WebElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********
  @Step ("Appium menu is shown.")
  public void appium_menu_toolbar_is_shown() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(AppiumNavbar, 30);
 	String actualString = mobiledriver.findElement(AppiumNavbar).getText();
  	// assertEquals that two Strings are equal
    Assert.assertEquals(actualString, "Appium", "Test Status: getText assertion failed!");
  	System.out.println("Test Status: appium menu is shown");
  }
  
  @Step ("Scroll to introducing appium.")
  public void scroll_to_introducing_appium() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(IntroducingAppium);
  	System.out.println("Test Status: Scrolled to h1 Introducing Appium");
  }
  
  @Step ("Scroll to watch the videos.")
  public void scroll_to_watch_the_videos() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(ShowDemoVideo);
  	System.out.println("Test Status: Scrolled to h2 Watch the Videos");
  }
  
  @Step ("Scroll to Appium easy setup process.")
  public void scroll_to_appium_setup() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(EasySetupProcess);
  	System.out.println("Test Status: Scrolled to h1 Easy Setup Process");
  }
}