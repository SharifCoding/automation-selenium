package integrationAppPage;

import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class AppScrollViewPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public AppScrollViewPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Facebook integration iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement main_view = mobiledriver.findElement(OtherMainView);
	  	Assert.assertTrue(main_view.isDisplayed());
		MobileElement navigation_bar = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Validate and click on the Scrolling button.")
	public void click_on_the_scroll_button() {
		MobileElement button_scrolling = mobiledriver.findElement(ButtonScrolling);
	  	Assert.assertTrue(button_scrolling.isDisplayed());
	  	button_scrolling.click();
		System.out.println("Test Status: clicked on the scrolling button");
	}
	
	@Step ("Validate the Scrolling page with the Navigation bar and the Back button.")
	public void validate_scrolling_page() {
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarUIView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
		System.out.println("Test Status: scrolling navigation bar is shown");
	}
	
	@Step ("Rotate and verify the device landscape orientation.")
	public void set_screen_orientation_to_landscape() {
		mobiledriver.rotate(ScreenOrientation.LANDSCAPE);
		Assert.assertEquals(ScreenOrientation.LANDSCAPE, mobiledriver.getOrientation());
		System.out.println("Test Status: device orientation set to landscape");
	}
	
	@Step ("Click on the scrollView button and validate.")
	public void click_on_the_scroll_view_button() {
		MobileElement button_table_view = mobiledriver.findElement(ButtonScrollView);
	  	Assert.assertTrue(button_table_view.isDisplayed());
	  	button_table_view.click();
		System.out.println("Test Status: clicked on the scroll_view button");
		MobileElement scroll_view = mobiledriver.findElement(NavigationBarFBScrollView);
	  	Assert.assertTrue(scroll_view.isDisplayed());
		System.out.println("Test Status: scroll_view page is loaded");
	}
	
	@Step ("Scroll down to a value on the scrollView.")
	public void navigate_to_scroll_view_value() {
		System.out.println("Test Status: executing scrollToElement function");
		scrollToElement(UIScrollViewValue);
		MobileElement scroll_view_value = mobiledriver.findElement(UIScrollViewValue);
		Assert.assertEquals(scroll_view_value.getText(), mScrollValue);
		System.out.println("Test Status: scrolled and verified value: " + scroll_view_value.getText());
	}
	
	@Step ("Return and validate the previous scrolling page.")
	public void return_to_scrolling_page() {
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
	  	button_back.click();
		MobileElement button_table_view = mobiledriver.findElement(ButtonTableView);
	  	Assert.assertTrue(button_table_view.isDisplayed());
		System.out.println("Test Status: returned to scrolling page (2)");
	}
	
	@Step ("Rotate and verify the device portrait orientation.")
	public void set_screen_orientation_to_portrait() {
		mobiledriver.rotate(ScreenOrientation.PORTRAIT);
		Assert.assertEquals(ScreenOrientation.PORTRAIT, mobiledriver.getOrientation());
		System.out.println("Test Status: device orientation set to portrait");
	}
	
	@Step ("Return and validate the main page.")
	public void return_to_main_page() {
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
	  	button_back.click();
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		System.out.println("Test Status: returned to main page");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: scroll view test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: scroll view test case completed");
	}
}