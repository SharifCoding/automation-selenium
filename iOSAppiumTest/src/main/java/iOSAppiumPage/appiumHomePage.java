package iOSAppiumPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
 
public class appiumHomePage extends basePage{
    
  //*********Web Page Class Constructor*********
  public appiumHomePage(IOSDriver<WebElement> mobiledriver) {
  	  basePage.mobiledriver = mobiledriver;
	}

  //*********Page Methods*********
  @Step ("Launch Appium home page.")
  public void launch_appium_home_page() {
  	// Open browser with desried URL
	mobiledriver.get(basePage.mURL);
  	System.out.println("Test Status: url loaded: "+ basePage.mURL);
  }
	
  @Step ("Check title once Appium home page is loaded.")
  public void check_title_of_page() {
    // Get page title
    String title = mobiledriver.getTitle();
    // Print page's title
    System.out.println("Test Status: page title \"" + title + "\"");
    // Assertion
	Assert.assertEquals(mobiledriver.getCurrentUrl(), basePage.mURL, "URL Mismatch");
	Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}