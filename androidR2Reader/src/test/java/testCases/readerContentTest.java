package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.readerContentPage;
 
public class readerContentTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google R2 Reader App")
	@Description ("The R2 Reader app is launched with content displayed.")
    public void androidR2ReaderContent () {
 
        //*************PAGE INSTANTIATIONS*************
		readerContentPage readerContentTest = new readerContentPage(mobiledriver);
 
        //*************PAGE METHODS********************
		readerContentTest.beforeTest();
		readerContentTest.first_launch_of_the_app();
		readerContentTest.add_book_button_is_displayed();
		readerContentTest.output_all_content();
		readerContentTest.swipe_down_and_up_content();
		readerContentTest.afterTest();
    }
}