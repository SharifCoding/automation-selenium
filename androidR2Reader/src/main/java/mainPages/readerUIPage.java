package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class readerUIPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public readerUIPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("The device storage permission is triggered with buttons; allow, and deny.")
  public void android_storage_permission() {
	MobileElement content_container = mobiledriver.findElement(permission_content_container);
  	Assert.assertTrue(content_container.isDisplayed());
    System.out.println("Test Status: device storage permission is triggered");
	MobileElement allow_button = mobiledriver.findElement(permission_allow_button);
  	Assert.assertTrue(allow_button.isDisplayed());
    System.out.println("Test Status: permission allow button is shown");
	MobileElement deny_button = mobiledriver.findElement(permission_deny_button);
  	Assert.assertTrue(deny_button.isDisplayed());
    System.out.println("Test Status: permission deny button is shown");
  }
  
  @Step ("Allow the device storage permission, and the R2 Reader app is loaded.")
  public void first_launch_of_the_app() {
	MobileElement allow_button = mobiledriver.findElement(permission_allow_button);
  	allow_button.click();
    System.out.println("Test Status: clicked on the permission allow button");
	MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
  	Assert.assertTrue(r2reader_container.isDisplayed());
    System.out.println("Test Status: app is loaded");
  }
  
  @Step ("Check the Title on the top UI, once the R2 Reader app has loaded.")
  public void check_title_of_the_app() {
    MobileElement app_title = mobiledriver.findElement(r2reader_action_bar_title);
	Assert.assertEquals(app_title.getText(), mAppTitle, "Test Status: getText assertion failed!");
    System.out.println("Test Status: expected app title: " + app_title.getText());
  }
  
  @Step ("Check the App version number via the More Options UI.")
  public void check_app_version_via_more_options() {
    MobileElement more_options = mobiledriver.findElement(r2reader_more_options);
    more_options.click();
    System.out.println("Test Status: clicked on more options");
	MobileElement about_r2_reader = mobiledriver.findElement(r2reader_about_r2_reader);
  	Assert.assertTrue(about_r2_reader.isDisplayed());
	MobileElement opds_feeds = mobiledriver.findElement(r2reader_opds_feeds);
  	Assert.assertTrue(opds_feeds.isDisplayed());
  	about_r2_reader.click();
	MobileElement app_version = mobiledriver.findElement(r2reader_app_version);
	Assert.assertEquals(app_version.getText(), mAppVersion, "Test Status: getText assertion failed!");
    System.out.println("Test Status: expected app version: " + app_version.getText());
  }
  
  @Step ("Tap on the Android back button to close the More Opions page.")
  public void tap_device_back_button() {
    mobiledriver.navigate().back();
    System.out.println("Test Status: clicked on the device back button");
	MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
  	Assert.assertTrue(r2reader_container.isDisplayed());
    System.out.println("Test Status: back to app main page");
  }
  
  @Step ("R2 Reader app basic UI test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: reader basic UI test loaded");
  }

  @Step ("R2 Reader app basic UI test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: reader basic UI test completed");
  }
}