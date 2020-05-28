package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class readereBookPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public readereBookPage(AndroidDriver<MobileElement>mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Allow the device storage permission, and the R2 Reader app is loaded.")
  public void first_launch_of_the_app() {
	MobileElement content_container = mobiledriver.findElement(permission_content_container);
  	Assert.assertTrue(content_container.isDisplayed());
	MobileElement allow_button = mobiledriver.findElement(permission_allow_button);
  	Assert.assertTrue(allow_button.isDisplayed());
	MobileElement deny_button = mobiledriver.findElement(permission_deny_button);
  	Assert.assertTrue(deny_button.isDisplayed());
  	allow_button.click();
	MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
  	Assert.assertTrue(r2reader_container.isDisplayed());
    System.out.println("Test Status: app is loaded");
  }
  
  @Step ("Search and click on the first content to open in the Readium eReader.")
  public void click_on_the_first_content() {
	searchAndClick(mAllContent[1]);
	MobileElement decor_content = mobiledriver.findElement(r2reader_resource_pager);
  	Assert.assertTrue(decor_content.isDisplayed());
    System.out.println("Test Status: first content is loaded");
  }
  
  @Step ("Swipe a few pages and then swipe from bottom to open the eReader UI.")
  public void swipe_few_pages_and_openui() {
    swipe(DIRECTION.RIGHT);
    swipe(DIRECTION.RIGHT);
    swipe(DIRECTION.LEFT);
    swipe(DIRECTION.OPENUI);
  }
  
  @Step ("Close the Readium eReader and return to the app.")
  public void close_readium_ereader() {
    mobiledriver.navigate().back();
    MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
  	Assert.assertTrue(r2reader_container.isDisplayed());
    System.out.println("Test Status: closed the ereader");
  }

@Step ("R2 Reader app eBook test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: reader ebook test loaded");
  }

  @Step ("R2 Reader app eBook test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: reader ebook test completed");
  }
}