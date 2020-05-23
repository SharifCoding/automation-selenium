package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.readerContentPage;
import mainPages.readerUIPage;
import mainPages.readereBookPage;
 
public class readerInitialContentTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("R2 Reader Basic UI")
	@Description ("The R2 Reader app is launched, storage permission allowed, and the basic UI are verified.")
    public void androidR2ReaderBasicUI () {
 
        //*************PAGE INSTANTIATIONS*************
		readerUIPage readerUITest = new readerUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		readerUITest.beforeTest();
		readerUITest.android_storage_permission();
		readerUITest.first_launch_of_the_app();
		readerUITest.check_title_of_the_app();
		readerUITest.check_app_version_via_more_options();
		readerUITest.tap_device_back_button();
		readerUITest.afterTest();
    }
	
	@Test (priority = 1)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("R2 Reader Content")
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
	
	@Test (priority = 2)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("R2 Reader eBook")
	@Description ("Tap on the chosen eBook to open in eReader.")
    public void androidR2ReaderBook () {
 
        //*************PAGE INSTANTIATIONS*************
		readereBookPage readereBookTest = new readereBookPage(mobiledriver);
 
        //*************PAGE METHODS********************
		readereBookTest.beforeTest();
		readereBookTest.first_launch_of_the_app();
		readereBookTest.click_on_the_first_content();
		readereBookTest.swipe_few_pages_and_openui();
		readereBookTest.close_readium_ereader();
		readereBookTest.afterTest();
    }
}