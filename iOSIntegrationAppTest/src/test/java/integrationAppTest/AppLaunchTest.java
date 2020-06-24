package integrationAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import integrationAppPage.AppLaunchPage;
 
public class AppLaunchTest extends BaseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and the expected options are shown.")
    public void facebookIntegrationAppIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		AppLaunchPage appLaunchTest = new AppLaunchPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appLaunchTest.beforeTest();
		appLaunchTest.launch_app_installed_via_xcode();
		appLaunchTest.check_navigation_bar();
		appLaunchTest.check_available_buttons();
		appLaunchTest.check_text_portrait();
		appLaunchTest.afterTest();
    }
}