package appiumiOSTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;
import iOSAppiumPage.appiumNavigatePage;
 
public class appiumNavigateTest extends baseTest{

	@Test
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("Navigate the Appium Home page.")
	public void appiumNavigationCheck () throws InterruptedException {
		 
		//*************PAGE INSTANTIATIONS*************
		appiumNavigatePage appiumNavigateTest = new appiumNavigatePage(mobiledriver);
		
		//*************PAGE METHODS********************
		appiumNavigateTest.beforeTest();
		appiumNavigateTest.launch_appium_home_page();
		appiumNavigateTest.check_title_of_page();
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