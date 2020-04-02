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
  By ProjectsContainer = By.className("project");
  By AboutMeContainer = By.className("aboutme");
  By ExperienceContainer = By.className("experience");
  By CopyrightContainer = By.className("footer");
    
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
  	WebElement githubButton = browser.findElement(GithubButton);
  	String githubTxt = githubButton.getText();
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(githubButton.isDisplayed());
  	// assertEquals that two Strings are equal
    Assert.assertEquals(githubTxt, "Github", "Test Status: getText assertion failed!");
	System.out.println("Test Status: Github Button is present");
  }
	
  @Step ("Github pages includes Blogger action button.")
  public void blogger_button_shown() {
  	// locating an element by CSS ID
  	WebElement bloggerButton = browser.findElement(BloggerButton);
  	String bloggerTxt = bloggerButton.getText();
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(bloggerButton.isDisplayed());
  	// assertEquals that two Strings are equal
    Assert.assertEquals(bloggerTxt, "Blogger", "Test Status: getText assertion failed!");
	System.out.println("Test Status: Blogger Button is present");
  }
  
  @Step ("Github pages includes Email Me action button.")
  public void email_me_button_shown() {
  	// locating an element by CSS ID
  	WebElement emailButton = browser.findElement(EmailMeButton);
  	String emailTxt = emailButton.getText();
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(emailButton.isDisplayed());
  	// assertEquals that two Strings are equal
    Assert.assertEquals(emailTxt, "Email Me", "Test Status: getText assertion failed!");
	System.out.println("Test Status: Email Me Button is present");
  }

  @Step ("Scroll to the Projects section.")
  public void scroll_to_projects_container() {
	// call action methods and scroll to element
	scrollToElement(ProjectsContainer);
	System.out.println("Test Status: Scroll to Projects Container");
  }
  
  @Step ("Scroll to the About Me section.")
  public void scroll_to_about_me_container() {
	// call action methods and scroll to element
	scrollToElement(AboutMeContainer);
	System.out.println("Test Status: Scroll to About Me Container");
  }
  
  @Step ("Scroll to the Experience section.")
  public void scroll_to_experince_container() {
	// call action methods and scroll to element
	scrollToElement(ExperienceContainer);
	System.out.println("Test Status: Scroll to Experience Container");
  }
  
  @Step ("Scroll to the Copyright section.")
  public void scroll_to_copyright_container() {
	// call action methods and scroll to element
	scrollToElement(CopyrightContainer);
	System.out.println("Test Status: Scroll to Copyright Container");
  }
}