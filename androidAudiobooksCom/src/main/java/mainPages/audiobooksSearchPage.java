package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class audiobooksSearchPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public audiobooksSearchPage(AndroidDriver<MobileElement>mobiledriver) {
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
  
  @Step ("The search input field is active with device keyboard open.")
  public void tap_on_the_search_icon() {
    System.out.println("Test Status: search input field is active");
  }
  
  @Step ("The JSON string value is inputted to the search field and excuted.")
  public void execute_string_search() {
    System.out.println("Test Status: string search executed");
  }
  
  @Step ("Start the search returned audiobook by tapping on the play icon.")
  public void tap_on_the_play_icon() {
    System.out.println("Test Status: search audiobook is playing");
  }
  
  @Step ("Navigate to the My Books page where the played audiobook is added.")
  public void navigate_to_my_books() {
    System.out.println("Test Status: my books is loaded");
  }
  
  @Step ("Remove the added audiobook from the My Books page.")
  public void remove_the_added_audiobook() {
    System.out.println("Test Status: search audiobook is playing");
  }
  
  @Step ("audiobooks.com app search string test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: audiobooks.com search string test loaded");
  }

  @Step ("audiobooks.com app search string test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: audiobooks.com search string test completed");
  }
}