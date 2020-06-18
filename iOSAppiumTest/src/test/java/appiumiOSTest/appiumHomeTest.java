package appiumiOSTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;
import iOSAppiumPage.appiumHomePage;
 
public class appiumHomeTest extends baseTest{
	
	@Test
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Appium Home Page")
	@Description ("The Appium Home Page is loaded.")
    public void appiumHomePageIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		appiumHomePage appiumHomeTest = new appiumHomePage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appiumHomeTest.beforeTest();
		appiumHomeTest.launch_appium_home_page();
		appiumHomeTest.check_title_of_page();
		appiumHomeTest.afterTest();
    }
}