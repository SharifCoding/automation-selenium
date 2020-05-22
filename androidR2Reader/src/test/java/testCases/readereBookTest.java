package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.readereBookPage;
 
public class readereBookTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google R2 Reader App")
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