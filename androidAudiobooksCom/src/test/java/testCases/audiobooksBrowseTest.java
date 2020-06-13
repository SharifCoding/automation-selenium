package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.audiobooksBrowsePage;
 
public class audiobooksBrowseTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("audiobooks.com app basic UI")
	@Description ("The audiobooks.com app is launched, and the Browse page is verified.")
    public void androidAudiobooksBrowse () {
 
        //*************PAGE INSTANTIATIONS*************
		audiobooksBrowsePage audiobooksBrowseTest = new audiobooksBrowsePage(mobiledriver);
 
        //*************PAGE METHODS********************
		audiobooksBrowseTest.beforeTest();
		audiobooksBrowseTest.first_launch_of_the_app();
		audiobooksBrowseTest.check_title_of_the_app();
		audiobooksBrowseTest.open_menu_and_click_browse();
		audiobooksBrowseTest.check_title_of_browse_page();
		audiobooksBrowseTest.scroll_to_chosen_browse_option();
		audiobooksBrowseTest.scroll_to_chosen_browse_sub_option();
		audiobooksBrowseTest.verify_sort_container();
		audiobooksBrowseTest.click_on_the_sort_option();
		audiobooksBrowseTest.validate_each_sort_option();
		audiobooksBrowseTest.select_sort_option();
		audiobooksBrowseTest.afterTest();
    }
}