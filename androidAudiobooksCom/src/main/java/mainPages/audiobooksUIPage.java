package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class audiobooksUIPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public audiobooksUIPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	  
  @Step ("The audiobooks.com app is launched, and loaded on the Featured page.")
  public void first_launch_of_the_app() {
	MobileElement content_container = mobiledriver.findElement(audiobooks_main_content);
  	Assert.assertTrue(content_container.isDisplayed());
    System.out.println("Test Status: app is loaded");
	MobileElement main_toolbar = mobiledriver.findElement(audiobooks_main_toolbar);
  	Assert.assertTrue(main_toolbar.isDisplayed());
    System.out.println("Test Status: app main toolbar is shown");
  }
  
  @Step ("Check the Featured title on the top UI, and then the Audiobooks title after opening the menu.")
  public void check_title_of_the_app() {
    MobileElement featured_titles = mobiledriver.findElement(audiobooks_featured_titles);
  	Assert.assertTrue(featured_titles.isDisplayed());
    System.out.println("Test Status: featured title is shown");
    MobileElement menu_open = mobiledriver.findElement(audiobooks_menu_open);
    menu_open.click();
    System.out.println("Test Status: clicked on menu to open");
    MobileElement audiobooks_titles = mobiledriver.findElement(audiobooks_menu_audiobooks_titles);
  	Assert.assertTrue(audiobooks_titles.isDisplayed());
    System.out.println("Test Status: audiobooks title is shown");
  }
  
  @Step ("Check the app version number via the Menu UI.")
  public void check_app_version_via_menu() {
	MobileElement menu_open = mobiledriver.findElement(audiobooks_menu_open);
    menu_open.click();
    System.out.println("Test Status: clicked on menu to close");
  }
  
  @Step ("audiobooks.com app basic UI test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: audiobooks.com basic UI test loaded");
  }

  @Step ("audiobooks.com app basic UI test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: audiobooks.com basic UI test completed");
  }
}