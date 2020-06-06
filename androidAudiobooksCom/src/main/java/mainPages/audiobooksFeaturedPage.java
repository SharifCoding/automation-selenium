package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class audiobooksFeaturedPage extends basePage{
    
	//*********Web Page Class Constructor*********
	public audiobooksFeaturedPage(AndroidDriver<MobileElement>mobiledriver) {
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
	  
	@Step ("Scroll down the first shelve and verify content.")
	public void scroll_and_verify_shelve_one() {
		scrollToShelve("Featured Free Fiction Audiobooks");
		scrollHorizontal("Space Prison");
	}
	
	@Step ("Scroll down the second shelve and verify content.")
	public void scroll_and_verify_shelve_two() {
		scrollToShelve("Featured Free Non-Fiction Audiobooks");
		scrollToShelveInstance("1");
		//scrollHorizontal("Wealth of Nations");
	}
	
	@Step ("Scroll down shelves pass the first two with additional offset swipe.")
	public void scroll_and_verify_shelve_three() {
		scrollToShelve("Featured Free Kids Audiobooks");
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