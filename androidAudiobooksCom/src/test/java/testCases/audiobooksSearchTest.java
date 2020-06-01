package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.audiobooksSearchPage;
 
public class audiobooksSearchTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("audiobooks.com app basic UI")
	@Description ("The audiobooks.com app is launched, and a string search is executed.")
    public void androidAudiobooksSearch () {
 
		//*************PAGE INSTANTIATIONS*************
		audiobooksSearchPage audiobooksSearchTest = new audiobooksSearchPage(mobiledriver);
 
		//*************PAGE METHODS********************
		audiobooksSearchTest.beforeTest();
		audiobooksSearchTest.first_launch_of_the_app();
		audiobooksSearchTest.tap_on_the_search_icon();
		audiobooksSearchTest.execute_string_search();
		audiobooksSearchTest.validate_search_return();
		audiobooksSearchTest.tap_on_the_play_icon();
		audiobooksSearchTest.validate_audiobook_player();
		audiobooksSearchTest.navigate_to_my_books();
		audiobooksSearchTest.remove_the_added_audiobook();
		audiobooksSearchTest.afterTest();
	}
}