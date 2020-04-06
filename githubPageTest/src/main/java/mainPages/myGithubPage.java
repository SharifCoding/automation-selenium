package mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.qameta.allure.Step;
 
public class myGithubPage extends basePage{
 
  //*********Web Elements*********
  By GithubBody = By.id("myGithubPages");
  By HeaderButtons = By.xpath("//*[@id='headerButtons']//a");
  By GithubButton = By.id("githubButton");
  By BloggerButton = By.id("bloggerButton");
  By EmailMeButton = By.id("emailMeButton");
  By ProjectsContainer = By.className("project");
  By PersonalProject = By.xpath("//*[@id='personalProjectButtons']//li//a");
  By ClassProject = By.xpath("//*[@id='classProjectButtons']//li//a");
  By ProjectOne = By.id("projectOne");
  By ProjectTwo = By.id("projectTwo");
  By ProjectThree = By.id("projectThree");
  By ProjectFour = By.id("projectFour");
  By ProjectFive = By.id("projectFive");
  By ProjectSix = By.id("projectSix");
  By AboutMeContainer = By.className("aboutme");
  By GridrightIcons = By.xpath("//*[@id='gridrightIcons']//img");
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
    Assert.assertEquals(githubTxt, "GitHub", "Test Status: getText assertion failed!");
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
  
  @Step ("Verify Github, Blogger, and Email Me action buttons.")
  public void verify_header_action_buttons() {
    // Call function to catch all web elements into list and verify with provided attribute
	checkListAttribute(HeaderButtons, "href");
	System.out.println("Test Status: Action buttons verified");
	array_list.forEach(t -> System.out.println("Test Status: <a href=\"" + t + "\">"));
  }
  
  @Step ("Hover over each Projects.")
  public void hover_over_each_projects() throws InterruptedException {
	// call action methods and scroll to element
	scrollToElement(ProjectsContainer);
	System.out.println("Test Status: Scroll to Projects Container");
    // assign all web elements into list
    WebElement array [] = {
		browser.findElement(ProjectOne),
		browser.findElement(ProjectTwo),
		browser.findElement(ProjectThree),
		browser.findElement(ProjectFour),
		browser.findElement(ProjectFive),
		browser.findElement(ProjectSix)
    };
    for(int i = 0; i <= array.length-1; i++)
    {
    	hoverOverElement(array[i]);
    	System.out.println("Test Status: Hover to project: " + array[i].getText());
    }
  }
  
  @Step ("Hover over each Personal Projects.")
  public void verify_personal_projects() throws InterruptedException {
    // Call function to catch all web elements into list and verify with provided attribute
	checkListAttribute(PersonalProject, "href");
	System.out.println("Test Status: Personal project URLs verified");
	array_list.forEach(t -> System.out.println("Test Status: <a href=\"" + t + "\">"));
  }
  
  @Step ("Hover over each Class Projects.")
  public void verify_class_projects() throws InterruptedException {
    // Call function to catch all web elements into list and verify with provided attribute
	checkListAttribute(ClassProject, "href");
	System.out.println("Test Status: Class project URLs verified");
	array_list.forEach(t -> System.out.println("Test Status: <a href=\"" + t + "\">"));
  }
  
  @Step ("Scroll to the About Me section.")
  public void scroll_to_about_me_container() {
	// call action methods and scroll to element
	scrollToElement(AboutMeContainer);
	System.out.println("Test Status: Scroll to About Me Container");
  }
  
  @Step ("Grab title tag from each image.")
  public void grab_title_tag_from_each_image() {
    // Call function to catch all web elements into list and verify with provided attribute
	checkListAttribute(GridrightIcons, "src");
	checkListAttribute(GridrightIcons, "title");
	System.out.println("Test Status: Title tags displayed verified");
	array_list.forEach(t -> System.out.println("Test Status: <img title=\"" + t + "\">"));
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
  
  @Step ("Validate the Copyright date.")
  public void validate_copyright_date() {
	// call action methods and scroll to element
	String Txt = browser.findElement(CopyrightContainer).getText();
	// assertEquals that two Strings are equal
	Assert.assertEquals(Txt, "Copyright © " + mDate + ", SharifCoding", "Test Status: getText assertion failed!");
	System.out.println("Test Status: Validated the Copyright date");
  }
}