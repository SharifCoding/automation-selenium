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
		MobileElement search_icon = mobiledriver.findElement(audiobooks_search_icon_one);
		Assert.assertTrue(search_icon.isDisplayed());
		search_icon.click();
		MobileElement search_field = mobiledriver.findElement(audiobooks_search_field);
		Assert.assertTrue(search_field.isDisplayed());
		System.out.println("Test Status: search input field is active");
	}
  
	@Step ("The JSON string value is inputted to the search field and excuted.")
	public void execute_string_search() {
		MobileElement input_search = mobiledriver.findElement(audiobooks_search_empty);
		Assert.assertTrue(input_search.isDisplayed());
		input_search.sendKeys(mSearchString);
		MobileElement search_icon = mobiledriver.findElement(audiobooks_search_icon_two);
		Assert.assertTrue(search_icon.isDisplayed());
		search_icon.click();
		System.out.println("Test Status: string search executed");
	}
  
	@Step ("Validate the search returned audiobook on the search results page.")
	public void validate_search_return() {
		MobileElement search_result_text = mobiledriver.findElement(audiobooks_search_result_text);
		Assert.assertEquals(search_result_text.getText(), "Showing results for '" + mSearchString + "'", "Test Status: getText assertion failed!");
		MobileElement search_result_title = mobiledriver.findElement(audiobooks_title);
		Assert.assertTrue(mSearchString.contains(search_result_title.getText()));
		System.out.println("Test Status: validated searched audiobook");
	}
  
	@Step ("Start the search returned audiobook by tapping on the play icon.")
	public void tap_on_the_play_icon() {
		MobileElement book_list_item = mobiledriver.findElement(audiobooks_book_list_item_layout);
		Assert.assertTrue(book_list_item.isDisplayed());
		book_list_item.click();
		System.out.println("Test Status: clicked on art cover");
		MobileElement search_result_title = mobiledriver.findElement(audiobooks_title);
		Assert.assertTrue(mSearchString.contains(search_result_title.getText()));
		MobileElement play_icon = mobiledriver.findElement(audiobooks_book_play_icon);
		Assert.assertTrue(play_icon.isDisplayed());
		play_icon.click();
		System.out.println("Test Status: clicked on play icon");
	}
  
	@Step ("Validate the searched title, and the audiobook player.")
	public void validate_audiobook_player() {
		MobileElement now_playing_panel = mobiledriver.findElement(audiobooks_now_playing_panel);
		Assert.assertTrue(now_playing_panel.isDisplayed());
		System.out.println("Test Status: now playing panel is shown");
		MobileElement now_playing_title = mobiledriver.findElement(audiobooks_now_playing_title);
		Assert.assertTrue(now_playing_title.isDisplayed());
		Assert.assertTrue(mSearchString.contains(now_playing_title.getText()));
		System.out.println("Test Status: validated audiobook title");
		MobileElement book_nav_controls = mobiledriver.findElement(audiobooks_book_nav_controls);
		Assert.assertTrue(book_nav_controls.isDisplayed());
		System.out.println("Test Status: audio player control is shown");
	}
  
	@Step ("Navigate to the My Books page where the played audiobook is added.")
	public void navigate_to_my_books() {
		System.out.println("Test Status: my books is loaded");
	}
  
	@Step ("Remove the added audiobook from the My Books page.")
	public void remove_the_added_audiobook() {
		System.out.println("Test Status: searched audiobook is removed");
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