package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class readerPushContentPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public readerPushContentPage(AndroidDriver<MobileElement> mobiledriver) {
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
  
  @Step ("Push content to device, and then add to the app.")
  public void push_content_to_device() {
	pushContentToDevice();
	MobileElement add_book = mobiledriver.findElement(r2reader_add_book);
  	Assert.assertTrue(add_book.isDisplayed());
    System.out.println("Test Status: add book button is displayed");
    //add_book.click();
  }
  
  @Step ("R2 Reader push content test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: push content test loaded");
  }

  @Step ("R2 Reader push content test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: push content test completed");
  }
}