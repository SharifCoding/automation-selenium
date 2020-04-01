package mainPages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.qameta.allure.Step;
 
public class myGithubPage extends basePage{
 
  //*********Web Elements*********
  By GithubBody = By.id("myGithubPages");
  By GithubButton = By.id("githubButton");
  By BloggerButton = By.id("bloggerButton");
  By EmailMeButton = By.id("emailMeButton");
    
  //*********Web Page Class Constructor*********
  public myGithubPage(WebDriver browser) {
  	  basePage.browser = browser;
	}

  //*********Page Methods*********
  @Step ("Launch my Github pages.")
  public void launch_my_github_page() {
  	// open browser with desried URL
  	browser.get(basePage.mURL);
  	System.out.println("Test Status: URL loaded: "+ basePage.mURL);
  	// locating an element by CSS ID
  	waitForElement(GithubBody, 30);
  }
	
  @Step ("Check title once Github pages is loaded.")
  public void check_title_of_page() {
    //Get page title
    String title = browser.getTitle();
    //Print page's title
    System.out.println("Test Status: Page Title \"" + title + "\"");
    //Assertion
    Assert.assertEquals(title, "SharifCoding", "Test Status: Title assertion is failed!");
  }
	
  @Step ("Github pages includes Github action button.")
  public void github_button_shown() {
  	// locating an element by CSS ID
  	WebElement searchButton = browser.findElement(GithubButton);
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(searchButton.isDisplayed());
	System.out.println("Test Status: Github Button is present");
  }
	
  @Step ("Github pages includes Blogger action button.")
  public void blogger_button_shown() {
  	// locating an element by CSS ID
  	WebElement luckyButton = browser.findElement(BloggerButton);
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(luckyButton.isDisplayed());
	System.out.println("Test Status: Blogger Button is present");
  }
  
  @Step ("Github pages includes Email Me action button.")
  public void email_me_button_shown() {
  	// locating an element by CSS ID
  	WebElement luckyButton = browser.findElement(EmailMeButton);
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(luckyButton.isDisplayed());
	System.out.println("Test Status: Email Me Button is present");
  }
}