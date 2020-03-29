package mainGoogle;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
 
public class googlePage extends basePage{
 
	//*********Web Elements*********
	By SearchInputField = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By SearchInputFieldTwo = By.xpath("/html/body/div[4]/form/div[2]/div[1]/div[2]/div/div[2]/input");
	By GoogleSearchButton = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[3]/center/input[1]");
	By GoogleSearchButtonTwo = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]");
	By FeelingLuckyButton = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[3]/center/input[2]");
	By FeelingLuckyButtonTwo = By.xpath("/html/body/div/div[4]/form/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[2]");
	By ResultStats = By.id("result-stats");
    
	//*********Web Page Class Constructor*********
	public googlePage(WebDriver browser) {
		basePage.browser = browser;
	}

	//*********Page Methods*********
	public void google_site_is_loaded() {
	  	// open browser with desried URL
	  	browser.get(basePage.mURL);
	  	System.out.println("Test Status: Google URL loaded: "+ basePage.mURL);
	  	// locating an element by CSS ID
	  	waitForElement(By.xpath("//body[@id='gsr']"), 30);
	}
	
	public void check_title_of_page() {
	    //Get page title
	    String title = browser.getTitle();
	    //Print page's title
	    System.out.println("Page Title: " + title);
	    //Assertion
	    Assert.assertEquals(title, "Google", "Test Status: Title assertion is failed!");
	}
	
	public void search_input_field_shown() {
	  	// locating an element by CSS ID
	  	WebElement body = browser.findElement(SearchInputField);
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(body.isDisplayed());
		System.out.println("Test Status: Search Input Field is present");
	}
	
	public void google_search_button_shown() {
	  	// locating an element by CSS ID
	  	WebElement searchButton = browser.findElement(GoogleSearchButton);
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(searchButton.isDisplayed());
		System.out.println("Test Status: Google Button is present");
	}
	
	public void feeling_lucky_button_shown() {
	  	// locating an element by CSS ID
	  	WebElement luckyButton = browser.findElement(FeelingLuckyButton);
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(luckyButton.isDisplayed());
		System.out.println("Test Status: Lucky Button is present");
	}
	
	public void input_string_to_search_field() {
		// keysToSend character sequence to send to the element
	  	browser.findElement(SearchInputField).sendKeys(basePage.mSearchString);
		System.out.println("Test Status: String value inputted");
	}
	
	
	public void google_search_button_shown_two() {
	  	// locating an element by CSS ID
	  	WebElement searchButtonTwo = browser.findElement(GoogleSearchButtonTwo);
		// checking that an element is present on the DOM of a page
		waitForElement(GoogleSearchButtonTwo, 10);
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(searchButtonTwo.isDisplayed());
		System.out.println("Test Status: Search button on predicted list is present");
	}
	
	public void feeling_lucky_button_shown_two() {
	  	// locating an element by CSS ID
	  	WebElement luckyButtonTwo = browser.findElement(FeelingLuckyButtonTwo);
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(luckyButtonTwo.isDisplayed());
		System.out.println("Test Status: Lucky button on predicted list is present");
	}
	
	public void execute_inputted_string() {
	  	// locating and click this element
	  	browser.findElement(GoogleSearchButtonTwo).click();;
		System.out.println("Test Status: Clicked on search button");
		// checking that an element is present on the DOM of a page
		waitForElement(ResultStats, 10);
	}
	
	public void get_value_from_searched_string() {
		String elementval = browser.findElement(SearchInputFieldTwo).getAttribute("value");
	    //Print page's title
	    System.out.println("Page Title: " + elementval);
	    //Assertion
	    Assert.assertEquals(elementval, basePage.mSearchString, "Test Status: Searched string assertion failed!");
		System.out.println("Test Status: Clicked on search button");
	}	
}