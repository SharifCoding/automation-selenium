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
}