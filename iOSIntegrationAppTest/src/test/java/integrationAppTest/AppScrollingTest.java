package integrationAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import integrationAppPage.AppScrollingPage;
 
public class AppScrollingTest extends BaseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and the expected options are shown.")
    public void facebookIntegrationAppIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		AppScrollingPage appScrollingTest = new AppScrollingPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appScrollingTest.beforeTest();
		appScrollingTest.validate_installed_app_via_xcode();
		appScrollingTest.click_on_the_scroll_button();
		appScrollingTest.afterTest();
    }
}