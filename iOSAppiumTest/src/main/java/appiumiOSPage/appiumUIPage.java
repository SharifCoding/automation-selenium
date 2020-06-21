package appiumiOSPage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
 
public class appiumUIPage extends basePage{

	//*********Web Page Class Constructor*********
	public appiumUIPage(IOSDriver<WebElement>mobiledriver) {
		basePage.mobiledriver = mobiledriver;
	}

	//*********Page Methods*********
	@Step ("Check title once Appium home page is loaded.")
	public void launch_appium_home_page() {
		mobiledriver.get(mURL);
		Assert.assertEquals(mobiledriver.getCurrentUrl(), mURL, "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), mTitle, "Title Mismatch");
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
	public void verify_each_hamburger_menu_option() {
		WebElement webArray [] = {
			mobiledriver.findElement(DropdownHome),
			mobiledriver.findElement(DropdownIntroduction),
			mobiledriver.findElement(DropdownGetStarted),
			mobiledriver.findElement(DropdownHistory),
			mobiledriver.findElement(DropdownGetInvolved),
			mobiledriver.findElement(DropdownDocumentation),
			mobiledriver.findElement(DropdownBooksResources)
		};
		String stringArray [] = {
			"Home",
			"Introduction",
			"Get started",
			"History",
			"Get Involved!",
			"Documentation",
			"Books & Resources",
		};
		for(int i = 0; i <= webArray.length-1; i++)
		{
			Assert.assertTrue(webArray[i].getText().contains(stringArray[i]));
		}
		System.out.println("Test Status: appium hamburger menu verified");
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
  
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		mobiledriver.resetApp() ;
		System.out.println("Test Status: appiumUIPage is loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Status: appiumUIPage completed");
	}
}