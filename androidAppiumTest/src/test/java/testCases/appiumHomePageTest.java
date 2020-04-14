package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import mainPages.appiumHomePage;
import mainPages.appiumHomeUIPage;
import mainPages.appiumNavigatePage;
 
public class appiumHomePageTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium Home Page is loaded.")
    public void appiumHomePageIsLoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		appiumHomePage appiumHomeTest = new appiumHomePage(mobiledriver);
 
        //*************PAGE METHODS********************
		appiumHomeTest.launch_appium_home_page();
		appiumHomeTest.check_title_of_page();
    }
	
	@Test (priority = 1)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium Home UI are loaded.")
    public void appiumHomeUILoaded () throws InterruptedException {
 
        //*************PAGE INSTANTIATIONS*************
		appiumHomeUIPage appiumHomeUITest = new appiumHomeUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		appiumHomeUITest.appium_menu_toolbar_is_shown();
		appiumHomeUITest.click_on_hamburger_icon_to_expand();
		appiumHomeUITest.hover_over_each_hamburger_menu_option();
		appiumHomeUITest.click_on_hamburger_icon_to_close();
		appiumHomeUITest.appium_download_button_is_shown();
    }
	
	@Test (priority = 2)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("Navigate the Appium Home page.")
    public void appiumNavigationCheck () throws InterruptedException {
 
        //*************PAGE INSTANTIATIONS*************
		appiumNavigatePage appiumNavigateTest = new appiumNavigatePage(mobiledriver);
 
        //*************PAGE METHODS********************
		appiumNavigateTest.appium_menu_toolbar_is_shown();
		appiumNavigateTest.scroll_to_introducing_appium();
		appiumNavigateTest.verify_marketing_byline();
		appiumNavigateTest.scroll_to_watch_the_videos();
		appiumNavigateTest.verify_demo_videos();
		appiumNavigateTest.scroll_to_appium_setup();
		appiumNavigateTest.verify_appium_setup();
    }
}