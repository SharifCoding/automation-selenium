package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.audiobooksFeaturedPage;
 
public class audiobooksFeaturedTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("audiobooks.com app basic UI")
	@Description ("The audiobooks.com app is launched, and the Featured page is verified.")
    public void androidAudiobooksFeatured () {
 
        //*************PAGE INSTANTIATIONS*************
		audiobooksFeaturedPage audiobooksFeaturedTest = new audiobooksFeaturedPage(mobiledriver);
 
        //*************PAGE METHODS********************
		audiobooksFeaturedTest.beforeTest();
		audiobooksFeaturedTest.first_launch_of_the_app();
		audiobooksFeaturedTest.check_title_of_the_app();
		audiobooksFeaturedTest.scroll_and_verify_first_shelve();
		audiobooksFeaturedTest.scroll_and_verify_second_shelve();
		audiobooksFeaturedTest.scroll_and_verify_third_shelve();
		audiobooksFeaturedTest.scroll_and_verify_random_shelve();
		audiobooksFeaturedTest.afterTest();
    }
}