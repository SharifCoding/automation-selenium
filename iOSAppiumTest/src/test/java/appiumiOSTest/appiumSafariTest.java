package appiumiOSTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import appiumiOSPage.appiumHomePage;
import appiumiOSPage.appiumNavigatePage;
import appiumiOSPage.appiumUIPage;
 
public class appiumSafariTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium home page is loaded, and the expected title is shown.")
    public void appiumHomePageIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		appiumHomePage appiumHomeTest = new appiumHomePage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appiumHomeTest.beforeTest();
		appiumHomeTest.launch_appium_home_page();
		appiumHomeTest.check_title_of_page();
		appiumHomeTest.afterTest();
    }
	
	@Test (priority = 1)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium home page is loaded, and the each menu option via the hamburger icon is validated.")
	public void appiumHomeUILoaded () throws InterruptedException {
		 
		//*************PAGE INSTANTIATIONS*************
		appiumUIPage appiumUITest = new appiumUIPage(mobiledriver);
		
		//*************PAGE METHODS********************
		appiumUITest.beforeTest();
		appiumUITest.launch_appium_home_page();
		appiumUITest.appium_menu_toolbar_is_shown();
		appiumUITest.click_on_hamburger_icon_to_expand();
		appiumUITest.verify_each_hamburger_menu_option();
		appiumUITest.click_on_hamburger_icon_to_close();
		appiumUITest.appium_download_button_is_shown();
		appiumUITest.afterTest();
	}
	
	@Test (priority = 2)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium home page is loaded, and navigated various area of the page.")
	public void appiumNavigationCheck () throws InterruptedException {
		 
		//*************PAGE INSTANTIATIONS*************
		appiumNavigatePage appiumNavigateTest = new appiumNavigatePage(mobiledriver);
		
		//*************PAGE METHODS********************
		appiumNavigateTest.beforeTest();
		appiumNavigateTest.launch_appium_home_page();
		appiumNavigateTest.appium_menu_toolbar_is_shown();
		appiumNavigateTest.scroll_to_introducing_appium();
		appiumNavigateTest.verify_marketing_byline();
		appiumNavigateTest.scroll_to_watch_the_videos();
		appiumNavigateTest.verify_demo_videos();
		appiumNavigateTest.scroll_to_appium_setup();
		appiumNavigateTest.verify_appium_setup();
		appiumNavigateTest.afterTest();
	}
}