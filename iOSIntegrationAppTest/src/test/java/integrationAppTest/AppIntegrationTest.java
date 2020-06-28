package integrationAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import integrationAppPage.AppLaunchPage;
import integrationAppPage.AppScrollingPage;
 
public class AppIntegrationTest extends BaseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and the expected options are shown.")
	public void facebookIntegrationAppIsLoaded () {
 
		//*************PAGE INSTANTIATIONS*************
		AppLaunchPage appLaunchTest = new AppLaunchPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appLaunchTest.beforeTest();
		appLaunchTest.validate_installed_app_via_xcode();
		appLaunchTest.check_navigation_bar();
		appLaunchTest.check_available_buttons();
		appLaunchTest.check_orientation_text();
		appLaunchTest.afterTest();
	}
	
	@Test (priority = 1)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and scrolled on the loaded scrolling pages.")
	public void facebookIntegrationAppScrolling () {
 
		//*************PAGE INSTANTIATIONS*************
		AppScrollingPage appScrollingTest = new AppScrollingPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appScrollingTest.beforeTest();
		appScrollingTest.validate_installed_app_via_xcode();
		appScrollingTest.click_on_the_scroll_button();
		appScrollingTest.validate_scrolling_page();
		appScrollingTest.click_on_the_table_view_button();
		appScrollingTest.navigate_to_table_view_value();
		appScrollingTest.return_to_scrolling_page_one();
		appScrollingTest.click_on_the_scroll_view_button();
		appScrollingTest.navigate_to_scroll_view_value();
		appScrollingTest.return_to_scrolling_page_two();
		appScrollingTest.afterTest();
	}
}