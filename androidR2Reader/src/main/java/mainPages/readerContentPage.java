package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class readerContentPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public readerContentPage(AndroidDriver<MobileElement> mobiledriver) {
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
  
  public void add_book_button_is_displayed() {
	MobileElement add_book = mobiledriver.findElement(r2reader_add_book);
  	Assert.assertTrue(add_book.isDisplayed());
    System.out.println("Test Status: add book button is displayed");
  }
  
  public void swipe_down_and_up_content() {
    swipe(DIRECTION.DOWN);
    swipe(DIRECTION.UP);
  }
  
  @Step ("R2 Reader app content test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: reader content test loaded");
  }

  @Step ("R2 Reader app content test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: reader content test completed");
  }
}