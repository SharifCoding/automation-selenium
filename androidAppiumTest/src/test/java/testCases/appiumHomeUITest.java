package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.appiumHomeUIPage;
 
public class appiumHomeUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home UI")
	@Description ("The Appium Home UI are loaded.")
    public void appiumHomeUILoaded () throws InterruptedException {
 
        //*************PAGE INSTANTIATIONS*************
		appiumHomeUIPage appiumHomeUIest = new appiumHomeUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		appiumHomeUIest.appium_menu_toolbar_is_shown();
		appiumHomeUIest.click_on_hamburger_icon_to_expand();
		appiumHomeUIest.hover_over_each_hamburger_menu_option();
		appiumHomeUIest.click_on_hamburger_icon_to_close();
		appiumHomeUIest.appium_download_button_is_shown();
		appiumHomeUIest.scroll_to_introducing_appium();
		appiumHomeUIest.scroll_to_watch_the_videos();
		appiumHomeUIest.scroll_to_appium_setup();
    }
}