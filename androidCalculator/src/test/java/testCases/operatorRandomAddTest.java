package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorRandomAddPage;
 
public class operatorRandomAddTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two random vaules using addition.")
    public void googleCalculatorOperatorRandomAdd () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorRandomAddPage operatorRandomAddTest = new operatorRandomAddPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorRandomAddTest.beforeTest();
		operatorRandomAddTest.input_first_random_value();
		operatorRandomAddTest.tap_on_operator_add();
		operatorRandomAddTest.input_second_random_value();
		operatorRandomAddTest.tap_on_equal_button();
		operatorRandomAddTest.verify_total_value();
		operatorRandomAddTest.afterTest();
    }
}