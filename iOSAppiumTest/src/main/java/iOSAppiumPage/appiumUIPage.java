package iOSAppiumPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
 
public class appiumUIPage extends basePage{
 
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
	public appiumUIPage(IOSDriver<WebElement>mobiledriver) {
		basePage.mobiledriver = mobiledriver;
	}

	//*********Page Methods*********
	@Step ("Launch Appium home page.")
	public void launch_appium_home_page() {
		mobiledriver.get(basePage.mURL);
		System.out.println("Test Status: url loaded: "+ basePage.mURL);
	}
		
	@Step ("Check title once Appium home page is loaded.")
	public void check_title_of_page() {
		String title = mobiledriver.getTitle();
		System.out.println("Test Status: page title \"" + title + "\"");
		Assert.assertEquals(mobiledriver.getCurrentUrl(), basePage.mURL, "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
	}
	
	@Step ("Appium menu is shown.")
	public void appium_menu_toolbar_is_shown() {
		waitForElement(AppiumNavbar, 30);
		String actualString = mobiledriver.findElement(AppiumNavbar).getText();
		Assert.assertEquals(actualString, "Appium", "Test Status: getText assertion failed!");
		System.out.println("Test Status: appium menu is shown");
	}

	@Step ("Expand hamburger menu.")
	public void click_on_hamburger_icon_to_expand() {
		waitForElement(HamburgerIcon, 30);
		mobiledriver.findElement(HamburgerIcon).click();
		waitForElement(HamburgerMenu, 30);
		System.out.println("Test Status: appium hamburger menu is expanded");
	}

	@Step ("Verify hamburger menu.")
	public void hover_over_each_hamburger_menu_option() throws InterruptedException {
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
			hoverOverElement(array[i]);
			System.out.println("Test Status: hoverOverElement.getText \"" + array[i].getText() + "\"");
		}
	}

	@Step ("Close hamburger menu.")
	public void click_on_hamburger_icon_to_close() {
		mobiledriver.findElement(HamburgerIcon).click();
		System.out.println("Test Status: appium hamburger menu is closed");
	}

	@Step ("Check the Appium download button is shown.")
	public void appium_download_button_is_shown() {
		waitForElement(DownloadButton, 30);
		String actualString = mobiledriver.findElement(DownloadButton).getText();
		Assert.assertTrue(actualString.contains("Download Appium"));
		System.out.println("Test Status: button \"" + actualString + "\" is shown");
	}
  
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Status: appiumUIPage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: appiumUIPage completed");
	}
}