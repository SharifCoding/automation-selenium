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
  By DropdownHome = By.xpath("//*[contains(text(), 'Home')]");
  By DropdownIntroduction = By.xpath("//*[contains(text(), 'Introduction')]");
  By DropdownGetStarted = By.xpath("//*[contains(text(), 'Get started')]");
  By DropdownHistory = By.xpath("//*[contains(text(), 'History')]");
  By DropdownGetInvolved = By.xpath("//*[contains(text(), 'Get Involved!')]");
  By DropdownDocumentation = By.xpath("//*[contains(text(), 'Documentation')]");
  By DropdownBooksResources = By.xpath("//*[contains(text(), 'Books & Resources')]");
    
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

  @Step ("Expand hamburger menu.")
  public void click_on_hamburger_icon_to_expand() {
	// Wait so that the app loads completely before starting with element identification
	waitForElement(HamburgerIcon, 30);
	//Find element by Class Name
	mobiledriver.findElement(HamburgerIcon).click();
	// Wait so that the app loads completely before starting with element identification
	waitForElement(HamburgerMenu, 30);
  	System.out.println("Test Status: appium hamburger menu is expanded");
  }
  
  @Step ("Verify hamburger menu.")
  public void hover_over_each_hamburger_menu_option() throws InterruptedException {
    // assign all web elements into list
    WebElement array [] = {
		mobiledriver.findElement(DropdownHome),
		mobiledriver.findElement(DropdownIntroduction),
		mobiledriver.findElement(DropdownGetStarted),
		mobiledriver.findElement(DropdownHistory),
		mobiledriver.findElement(DropdownGetInvolved),
		mobiledriver.findElement(DropdownDocumentation),
		mobiledriver.findElement(DropdownBooksResources),
    };
    for(int i = 0; i <= array.length-1; i++)
    {
    	// hover over each element in array
    	hoverOverElement(array[i]);
    	System.out.println("Test Status: hoverOverElement.getText \"" + array[i].getText() + "\"");
    }    
  }
  
  @Step ("Close hamburger menu.")
  public void click_on_hamburger_icon_to_close() {
	// find element by Class Name
	mobiledriver.findElement(HamburgerIcon).click();
  	System.out.println("Test Status: appium hamburger menu is closed");
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