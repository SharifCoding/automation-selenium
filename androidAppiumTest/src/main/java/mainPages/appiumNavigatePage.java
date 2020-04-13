package mainPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class appiumNavigatePage extends basePage{
 
  //*********Web Elements*********
  By AppiumNavbar = By.className("navbar-brand");
  By IntroducingAppium = By.id("introducing-appium");
  By MarketingByline = By.className("marketing-byline");
  By WatchVideosButton = By.xpath("//*[contains(text(), 'Watch the Videos')]");
  By ShowDemoVideo = By.id("show-demo-video");
  By DemoVideoElements = By.xpath("//*[@id='show-demo-video']//iframe");
  By EasySetupProcess = By.xpath("//*[@data-localize='easy-setup']");
    
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
 	String expectedString = "Appium";
  	// assertEquals that two Strings are equal
    Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
  }
  
  @Step ("Scroll to introducing appium.")
  public void scroll_to_introducing_appium() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(IntroducingAppium);
  	System.out.println("Test Status: Scrolled to h1 Introducing Appium");
  }
  
  @Step ("Verify the marketing byline.")
  public void verify_marketing_byline() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(MarketingByline, 30);
 	String actualString = mobiledriver.findElement(MarketingByline).getText();
 	String expectedString = "Is native app automation missing from your tool belt? Problem solved.";
  	// assertEquals that two Strings are equal
    Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
  	System.out.println("Test Status: Marketing byline verified");
  }
  
  @Step ("Scroll to watch the videos.")
  public void scroll_to_watch_the_videos() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(ShowDemoVideo);
  	System.out.println("Test Status: Scrolled to h2 Watch the Videos");
  }
  
  @Step ("Verify each demo video sources.")
  public void verify_demo_videos() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(WatchVideosButton, 30);
	//Find element by Class Name
	mobiledriver.findElement(WatchVideosButton).click();
  	System.out.println("Test Status: Clicked on Watch Videos");
    // To catch all web elements into list
    List<WebElement> myList=mobiledriver.findElements(DemoVideoElements);
    // myList contains all the web elements
    // To get all elements href into array list
    List<String> all_elements_attribute=new ArrayList<>();
    for(int i=0; i<myList.size(); i++){
        // Loading href of each element in to array all_elements_href
    	all_elements_attribute.add(myList.get(i).getAttribute("src"));
        // Asserts that an object isn't null. If it is, an AssertionError is thrown.
        Assert.assertNotNull(myList.get(i).getAttribute("src"));
    }
    all_elements_attribute.forEach(t -> System.out.println("Test Status: <iframe src=\"" + t + "\">"));
  	System.out.println("Test Status: Demo videos verified");
  }
  
  @Step ("Scroll to Appium easy setup process.")
  public void scroll_to_appium_setup() {
	// Wait so that the app loads completely before starting with element identification
	scrollToElement(EasySetupProcess);
  	System.out.println("Test Status: Scrolled to h1 Easy Setup Process");
  }
  
  @Step ("Verify the Appium easy setup.")
  public void verify_appium_setup() {
 	String actualString = mobiledriver.findElement(EasySetupProcess).getText();
 	String expectedString = "Easy setup process, run a test now.";
  	// assertEquals that two Strings are equal
    Assert.assertEquals(actualString, expectedString, "Test Status: getText assertion failed!");
  	System.out.println("Test Status: Easy setup verified");
  }
}