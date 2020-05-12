package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.readerUIPage;
 
public class readerUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google R2 Reader App")
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
		readerUITest.afterTest();
    }
}