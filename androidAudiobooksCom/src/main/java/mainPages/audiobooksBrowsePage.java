package mainPages;

import org.openqa.selenium.WebElement;
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
	
	@Step ("Scroll down to the chosen browse option and click.")
	public void scroll_to_chosen_browse_option() {
		MobileElement browse_option = scrollToBrowseOption(mRandomBrowseOption);
		browse_option.click();		
		MobileElement browse_option_title = mobiledriver.findElement(audiobooks_browse_menu_title);
		Assert.assertEquals(browse_option_title.getText(), mRandomBrowseOption, "Test Status: getText assertion failed!");
		System.out.println("Test Status: expected browse page is loaded: " + mRandomBrowseOption);
	}
	
	@Step ("Scroll down to the chosen browse sub option and click.")
	public void scroll_to_chosen_browse_sub_option() {
		MobileElement browse_option = scrollToBrowseOption(mRandomBrowseSubOption);
		browse_option.click();		
		MobileElement browse_option_title = mobiledriver.findElement(audiobooks_browse_menu_title);
		Assert.assertEquals(browse_option_title.getText(), mRandomBrowseSubOption, "Test Status: getText assertion failed!");
		System.out.println("Test Status: expected browse page is loaded: " + mRandomBrowseOption + " > " + mRandomBrowseSubOption);
	}
	
	@Step ("Verify the sort default options and the sort button.")
	public void verify_sort_container() {	
		MobileElement sort_container = mobiledriver.findElement(audiobooks_sort_container);
		Assert.assertTrue(sort_container.isDisplayed());
		MobileElement txtResultsLabel = mobiledriver.findElement(audiobooks_txtResultsLabel);
		Assert.assertEquals(txtResultsLabel.getText(), "Sorted By: Best Selling this Month", "Test Status: getText assertion failed!");
		System.out.println("Test Status: default sort option is verified");
	}
	
	@Step ("Tap on the sort button to open available sort options.")
	public void click_on_the_sort_option() {	
		MobileElement sortBtn = mobiledriver.findElement(audiobooks_sortBtn);
		Assert.assertTrue(sortBtn.isDisplayed());
		sortBtn.click();
		MobileElement select_dialog_listview = mobiledriver.findElement(audiobooks_select_dialog_listview);
		Assert.assertTrue(select_dialog_listview.isDisplayed());
		System.out.println("Test Status: tapped on the sort button");
	}
	
	@Step ("Validate each available sort options.")
	public void validate_each_sort_option() {					
	    WebElement arrayMobileElements [] = {
			mobiledriver.findElement(audiobooks_sort_text1_one), mobiledriver.findElement(audiobooks_sort_text1_two),
			mobiledriver.findElement(audiobooks_sort_text1_three), mobiledriver.findElement(audiobooks_sort_text1_four),
			mobiledriver.findElement(audiobooks_sort_text1_five), mobiledriver.findElement(audiobooks_sort_text1_six)
	    };
	    String arrayExpectedValues [] = {
	    	"Publication Date", "Recently Added", "Highest Rated",
	    	"Best Selling this Month", "Book Title [A-Z]", "Book Title [Z-A]"
	    };
	    for(int i = 0; i <= arrayMobileElements.length-1; i++)
	    {
	    	System.out.println("Test Status: assertEquals(actual; \"" + arrayMobileElements[i].getText()
	    	+ "\", expected; \"" + arrayExpectedValues[i] + "\")");
			Assert.assertEquals(arrayMobileElements[i].getText(), arrayExpectedValues[i], "Test Status: getText assertion failed!");
	    }
		System.out.println("Test Status: each sort options are verified");
	}
	
	@Step ("Tap on one of the sort sort option, and validate the retrun page.")
	public void select_sort_option() {	
		MobileElement sort_text1_five = mobiledriver.findElement(audiobooks_sort_text1_five);
		Assert.assertTrue(sort_text1_five.isDisplayed());
		sort_text1_five.click();
		MobileElement txtResultsLabel = mobiledriver.findElement(audiobooks_txtResultsLabel);
		Assert.assertEquals(txtResultsLabel.getText(), "Sorted By: Book Title [A-Z]", "Test Status: getText assertion failed!");
		System.out.println("Test Status: selected sort option is verified");
	}
	
	@Step ("audiobooks.com app browse test is loaded.")
	@BeforeTest
	public void beforeTest() {
		mobiledriver.resetApp() ;
		System.out.println("Test Case: audiobooks.com browse test loaded");
	}
	
	@Step ("audiobooks.com app browse test completed.")
	@AfterTest
	public void afterTest() {
		System.out.println("Test Case: audiobooks.com browse test completed");
	}
}