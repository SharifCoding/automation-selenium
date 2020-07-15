package wikipediaAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import wikipediaAppPage.AppLaunchPage;
import wikipediaAppPage.NavigateButtonsPage;

import org.testng.annotations.Test;
 
public class AppWikipediaTest extends BaseTest{
	
	@Test (priority = 0, enabled = false)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Wikipedia iOS App")
	@Description ("The Wikipedia iOS is launched, and the home page is shown.")
	public void wikipediaiOSAppIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		AppLaunchPage appLaunchTest = new AppLaunchPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appLaunchTest.beforeTest();
		appLaunchTest.validate_installed_app_via_xcode();
		appLaunchTest.check_buttons_wikipedia_and_settings();
		appLaunchTest.check_search_field();
		appLaunchTest.check_navigation_buttons();
		appLaunchTest.afterTest();
	}
	
	@Test (priority = 1, enabled = true)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Wikipedia iOS App")
	@Description ("The Wikipedia iOS is launched, and each navigation buttons is validated.")
	public void validateEachNavigationButtons () {
 
		//*************PAGE INSTANTIATIONS*************
		NavigateButtonsPage navigateButtonsTest = new NavigateButtonsPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		navigateButtonsTest.beforeTest();
		navigateButtonsTest.validate_installed_app_via_xcode();
		navigateButtonsTest.check_navigation_buttons();
		navigateButtonsTest.click_on_button_places();
		navigateButtonsTest.afterTest();
	}
}