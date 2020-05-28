package testCases;
 
import java.io.IOException;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.readerPushContentPage;
 
public class readerPushContentTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("R2 Reader Push Content")
	@Description ("The R2 Reader app is launched, and new content is added to the app.")
    public void androidR2ReaderPushContent () throws IOException {
 
        //*************PAGE INSTANTIATIONS*************
		readerPushContentPage readerPushContentTest = new readerPushContentPage(mobiledriver);
 
        //*************PAGE METHODS********************
		readerPushContentTest.beforeTest();
		readerPushContentTest.first_launch_of_the_app();
		readerPushContentTest.push_content_to_device();
		readerPushContentTest.search_the_pushed_content();
		readerPushContentTest.add_pushed_content_return_to_the_app();
		readerPushContentTest.verify_added_content();
		readerPushContentTest.click_on_the_added_content();
		readerPushContentTest.swipe_few_pages_and_openui();
		readerPushContentTest.close_readium_ereader();
		readerPushContentTest.afterTest();
    }
}