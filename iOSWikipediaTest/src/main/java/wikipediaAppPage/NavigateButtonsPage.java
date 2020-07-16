package wikipediaAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class NavigateButtonsPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public NavigateButtonsPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Wikipedia iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement toolbar = mobiledriver.findElement(Toolbar);
	  	Assert.assertTrue(toolbar.isDisplayed());
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		MobileElement button_settings = mobiledriver.findElement(ButtonSettings);
	  	Assert.assertTrue(button_settings.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Verify each navigation buttons on the bottom.")
	public void check_navigation_buttons() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
		MobileElement button_saved = mobiledriver.findElement(ButtonSaved);
	  	Assert.assertTrue(button_saved.isDisplayed());
		MobileElement button_history = mobiledriver.findElement(ButtonHistory);
	  	Assert.assertTrue(button_history.isDisplayed());
		MobileElement button_search = mobiledriver.findElement(ButtonSearch);
	  	Assert.assertTrue(button_search.isDisplayed());
		System.out.println("Test Status: navigation buttons are shown");
	}
	
	@Step ("Click on the navigation button; Places.")
	public void click_on_button_places() {
		MobileElement button_places = mobiledriver.findElement(ButtonPlaces);
	  	Assert.assertTrue(button_places.isDisplayed());
	  	button_places.click();
		System.out.println("Test Status: places button clicked");
	}
	
	@Step ("Validate category page; Places.")
	public void validate_category_places() {
		MobileElement text_places = mobiledriver.findElement(TextPlaces);
	  	Assert.assertTrue(text_places.isDisplayed());
		MobileElement button_filter = mobiledriver.findElement(ButtonFilter);
	  	Assert.assertTrue(button_filter.isDisplayed());
		MobileElement search_places = mobiledriver.findElement(SearchPlaces);
	  	Assert.assertTrue(search_places.isDisplayed());
		MobileElement show_as_list = mobiledriver.findElement(ShowAsList);
	  	Assert.assertTrue(show_as_list.isDisplayed());
		System.out.println("Test Status: validated places page");
	}
	
	@Step ("Click on the navigation button; Saved.")
	public void click_on_button_saved() {
		MobileElement button_saved = mobiledriver.findElement(ButtonSaved);
	  	Assert.assertTrue(button_saved.isDisplayed());
	  	button_saved.click();
		System.out.println("Test Status: saved button clicked");
	}
	
	@Step ("Validate category page; Saved.")
	public void validate_category_saved() {
		MobileElement text_saved = mobiledriver.findElement(TextSaved);
	  	Assert.assertTrue(text_saved.isDisplayed());
		MobileElement all_articles = mobiledriver.findElement(AllArticles);
	  	Assert.assertTrue(all_articles.isDisplayed());
		MobileElement reading_lists = mobiledriver.findElement(ReadingLists);
	  	Assert.assertTrue(reading_lists.isDisplayed());
		System.out.println("Test Status: validated saved page");
	}
	
	@Step ("Click on the navigation button; History.")
	public void click_on_button_history() {
		MobileElement button_history = mobiledriver.findElement(ButtonHistory);
	  	Assert.assertTrue(button_history.isDisplayed());
	  	button_history.click();
		System.out.println("Test Status: history button clicked");
	}
	
	@Step ("Validate category page; History.")
	public void validate_category_history() {
		MobileElement text_history = mobiledriver.findElement(TextHistory);
	  	Assert.assertTrue(text_history.isDisplayed());
		MobileElement clear = mobiledriver.findElement(ButtonClear);
	  	Assert.assertTrue(clear.isDisplayed());
		System.out.println("Test Status: validated history page");
	}
	
	@Step ("Click on the navigation button; Search.")
	public void click_on_button_search() {
		MobileElement button_search = mobiledriver.findElement(ButtonSearch);
	  	Assert.assertTrue(button_search.isDisplayed());
	  	button_search.click();
		System.out.println("Test Status: search button clicked");
	}
	
	@Step ("Validate category page; Search.")
	public void validate_category_search() {
		MobileElement text_search = mobiledriver.findElement(TextSearch);
	  	Assert.assertTrue(text_search.isDisplayed());
		MobileElement search_field = mobiledriver.findElement(SearchField);
	  	Assert.assertTrue(search_field.isDisplayed());
		MobileElement recently_searched = mobiledriver.findElement(RecentlySearched);
	  	Assert.assertTrue(recently_searched.isDisplayed());
		System.out.println("Test Status: validated search page");
	}
	
	@Step ("Click on the navigation button; Explore.")
	public void return_to_explore_page() {
		MobileElement button_explore = mobiledriver.findElement(ButtonExplore);
	  	Assert.assertTrue(button_explore.isDisplayed());
	  	button_explore.click();
		System.out.println("Test Status: explore button clicked");
		MobileElement button_wikipedia = mobiledriver.findElement(ButtonWikipedia);
	  	Assert.assertTrue(button_wikipedia.isDisplayed());
		System.out.println("Test Status: validated explore page");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: navigation buttons test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: navigation buttons test case completed");
	}
}