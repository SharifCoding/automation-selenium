package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.audiobooksUIPage;
 
public class audiobooksUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("audiobooks.com app basic UI")
	@Description ("The audiobooks.com app is launched, and the basic UI are verified.")
    public void androidR2ReaderBasicUI () {
 
        //*************PAGE INSTANTIATIONS*************
		audiobooksUIPage audiobooksUITest = new audiobooksUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		audiobooksUITest.beforeTest();
		audiobooksUITest.first_launch_of_the_app();
		audiobooksUITest.check_title_of_the_app();
		audiobooksUITest.scroll_down_and_click_settings();
		audiobooksUITest.check_app_version_via_menu();
		audiobooksUITest.afterTest();
    }
}