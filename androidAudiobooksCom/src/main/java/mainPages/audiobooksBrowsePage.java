package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class audiobooksBrowsePage extends basePage{
    
	//*********Web Page Class Constructor*********
	public audiobooksBrowsePage(AndroidDriver<MobileElement>mobiledriver) {
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
	  
	@Step ("Check the Featured title on the top UI.")
	public void check_title_of_the_app() {
		MobileElement featured_titles = mobiledriver.findElement(audiobooks_featured_titles);
		Assert.assertTrue(featured_titles.isDisplayed());
		System.out.println("Test Status: featured title is shown");
	}
	  
	@Step ("Open the menu, and then select the Browse option.")
	public void open_menu_and_click_browse() {
		MobileElement menu_open = mobiledriver.findElement(audiobooks_menu_open);
		menu_open.click();
		System.out.println("Test Status: clicked on menu to open");
		MobileElement menu_settings = mobiledriver.findElement(audiobooks_browse_menu_item);
		menu_settings.click();
		System.out.println("Test Status: clicked on browse");
	}
	
	@Step ("Check the Browse title on the top UI.")
	public void check_title_of_browse_page() {
		MobileElement browse_title = mobiledriver.findElement(audiobooks_browse_titles);
		Assert.assertTrue(browse_title.isDisplayed());
		System.out.println("Test Status: browse title is shown");
	}
	
	@Step ("Scroll down to a random browse option and click.")
	public void scroll_to_random_browse_option() {
		MobileElement browse_option = scrollToBrowseOption(mRandomBrowseOption);
		browse_option.click();		
		MobileElement browse_option_title = mobiledriver.findElement(audiobooks_menu_title);
		Assert.assertEquals(browse_option_title.getText(), mRandomBrowseOption, "Test Status: getText assertion failed!");
		System.out.println("Test Status: expected browse page is loaded: " + mRandomBrowseOption);
	}
	
	@Step ("audiobooks.com app featured test is loaded.")
	@BeforeTest
	public void beforeTest() {
		mobiledriver.resetApp() ;
		System.out.println("Test Case: audiobooks.com featured test loaded");
	}
	
	@Step ("audiobooks.com app featured test completed.")
	@AfterTest
	public void afterTest() {
		System.out.println("Test Case: audiobooks.com featured test completed");
	}
}