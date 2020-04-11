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
    public void appiumHomeUILoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		appiumHomeUIPage appiumHomeUIest = new appiumHomeUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		appiumHomeUIest.appium_menu_toolbar_is_shown();
		appiumHomeUIest.click_on_hamburger_icon_and_verify();
		appiumHomeUIest.appium_download_button_is_shown();

    }
}