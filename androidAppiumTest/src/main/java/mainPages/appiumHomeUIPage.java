package mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class appiumHomeUIPage extends basePage{
 
  //*********Web Elements*********
  By DownloadButton = By.id("downloadLink");
  By AppiumNavbar = By.className("navbar-brand");
  By HamburgerIcon = By.className("navbar-toggle");
  By HamburgerMenu = By.id("bs-example-navbar-collapse-1");
  By ProjectOne = By.id("projectOne");
  By ProjectTwo = By.id("projectTwo");
  By ProjectThree = By.id("projectThree");
  By ProjectFour = By.id("projectFour");
  By ProjectFive = By.id("projectFive");
  By ProjectSix = By.id("projectSix");
    
  //*********Web Page Class Constructor*********
  public appiumHomeUIPage(AndroidDriver<WebElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********
  @Step ("Appium menu is shown.")
  public void appium_menu_toolbar_is_shown() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(AppiumNavbar, 30);
 	String actualString = mobiledriver.findElement(AppiumNavbar).getText();
  	// assertEquals that two Strings are equal
    Assert.assertEquals(actualString, "Appium", "Test Status: getText assertion failed!");
  	System.out.println("Test Status: appium menu is shown");
  }

  @Step ("Verify hamburger menu.")
  public void click_on_hamburger_icon_and_verify() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(HamburgerIcon, 30);
	//Find element by Class Name
	mobiledriver.findElement(HamburgerIcon).click();
	// Wait so that the app loads completely before starting with element identification
	waitForElement(HamburgerMenu, 30);
	//Find element by Class Name
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Home')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Introduction')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Get started')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'History')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Get Involved!')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Documentation')]"));
	mobiledriver.findElement(By.xpath("//*[contains(text(), 'Books & Resources')]"));
	//Find element by Class Name
	mobiledriver.findElement(HamburgerIcon).click();
  	System.out.println("Test Status: appium hamburger icon is verified");
  }
  
  @Step ("Check the Appium download button is shown.")
  public void appium_download_button_is_shown() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(DownloadButton, 30);
  	String actualString = mobiledriver.findElement(DownloadButton).getText();
  	// assertTrue(boolean condition) Asserts that a condition is true
  	Assert.assertTrue(actualString.contains("Download Appium"));
  	// assertTrue(boolean condition) Asserts that a condition is true
  	System.out.println("Test Status: button \"" + actualString + "\" is shown");
  }
}