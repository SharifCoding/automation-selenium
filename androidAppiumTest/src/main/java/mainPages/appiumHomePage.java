package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class appiumHomePage extends basePage{
 
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
  public appiumHomePage(AndroidDriver<?> mobiledriver) {
  	  basePage.mobiledriver = mobiledriver;
	}

  //*********Page Methods*********
  @Step ("Launch Appium home page.")
  public void launch_appium_home_page() {
  	// open browser with desried URL
	mobiledriver.get(basePage.mURL);
  	System.out.println("Test Status: URL loaded: "+ basePage.mURL);
  }
	
  @Step ("Check title once Appium home page is loaded.")
  public void check_title_of_page() {
    //Get page title
    String title = mobiledriver.getTitle();
    //Print page's title
    System.out.println("Test Status: Page Title \"" + title + "\"");
    //Assertion
	Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
	Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
  }
}