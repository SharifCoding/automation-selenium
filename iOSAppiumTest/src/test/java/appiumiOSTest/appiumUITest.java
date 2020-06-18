package appiumiOSTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;
import iOSAppiumPage.appiumUIPage;
 
public class appiumUITest extends baseTest{

	@Test
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium Home UI are loaded.")
	public void appiumHomeUILoaded () throws InterruptedException {
		 
		//*************PAGE INSTANTIATIONS*************
		appiumUIPage appiumUITest = new appiumUIPage(mobiledriver);
		
		//*************PAGE METHODS********************
		appiumUITest.beforeTest();
		appiumUITest.launch_appium_home_page();
		appiumUITest.check_title_of_page();
		appiumUITest.appium_menu_toolbar_is_shown();
		appiumUITest.click_on_hamburger_icon_to_expand();
//		appiumUITest.hover_over_each_hamburger_menu_option();
		appiumUITest.click_on_hamburger_icon_to_close();
		appiumUITest.appium_download_button_is_shown();
		appiumUITest.afterTest();
	}
}