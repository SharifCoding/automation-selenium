package wikipediaAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import wikipediaAppPage.AppLaunchPage;

import org.testng.annotations.Test;
 
public class AppWikipediaTest extends BaseTest{
	
	@Test (priority = 0, enabled = true)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Wikipedia iOS App")
	@Description ("The Wikipedia iOS is launched, and the home page is shown.")
	public void facebookIntegrationAppIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		AppLaunchPage appLaunchTest = new AppLaunchPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appLaunchTest.beforeTest();
		appLaunchTest.validate_installed_app_via_xcode();
		appLaunchTest.check_search_field();
		appLaunchTest.afterTest();
	}
}