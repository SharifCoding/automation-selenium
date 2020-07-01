package integrationAppTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.annotations.Test;

import integrationAppPage.AppLaunchPage;
import integrationAppPage.AppAlertsPage;
import integrationAppPage.AppTableViewPage;
import integrationAppPage.AppScrollViewPage;
 
public class AppIntegrationTest extends BaseTest{
	
	@Test (priority = 0, enabled = true)
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
	
	@Test (priority = 1, enabled = true)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and validate on the loaded alerts page.")
	public void facebookIntegrationAlerts () {
 
		//*************PAGE INSTANTIATIONS*************
		AppAlertsPage appAlertsTest = new AppAlertsPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appAlertsTest.beforeTest();
		appAlertsTest.validate_installed_app_via_xcode();
		appAlertsTest.click_on_the_alerts_button();
		appAlertsTest.validate_alerts_page();
		appAlertsTest.return_to_main_page();
		appAlertsTest.afterTest();
	}
	
	@Test (priority = 2, enabled = true)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and validate on the loaded table view page.")
	public void facebookIntegrationAppTableView () {
 
		//*************PAGE INSTANTIATIONS*************
		AppTableViewPage appTableViewTest = new AppTableViewPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appTableViewTest.beforeTest();
		appTableViewTest.validate_installed_app_via_xcode();
		appTableViewTest.click_on_the_scroll_button();
		appTableViewTest.validate_scrolling_page();
		appTableViewTest.click_on_the_table_view_button();
		appTableViewTest.navigate_to_table_view_value();
		appTableViewTest.return_to_scrolling_page();
		appTableViewTest.return_to_main_page();
		appTableViewTest.afterTest();
	}
	
	@Test (priority = 3, enabled = true)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Facebook Integration App")
	@Description ("The Facebook Integration App is launched, and validate on the loaded scroll view page.")
	public void facebookIntegrationAppScrollView () {
 
		//*************PAGE INSTANTIATIONS*************
		AppScrollViewPage appScrollViewTest = new AppScrollViewPage(mobiledriver);
		 
		//*************PAGE METHODS********************
		appScrollViewTest.beforeTest();
		appScrollViewTest.validate_installed_app_via_xcode();
		appScrollViewTest.click_on_the_scroll_button();
		appScrollViewTest.validate_scrolling_page();
		appScrollViewTest.change_screen_orientation();
		appScrollViewTest.click_on_the_scroll_view_button();
		appScrollViewTest.navigate_to_scroll_view_value();
		appScrollViewTest.return_to_scrolling_page();
		appScrollViewTest.return_to_main_page();
		appScrollViewTest.afterTest();
	}
}