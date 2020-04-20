package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorMultiplyPage;
 
public class operatorMultiplyTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two vaules using multiplication.")
    public void googleCalculatorOperatorMultiply () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorMultiplyPage operatorMultiplyTest = new operatorMultiplyPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorMultiplyTest.beforeTest();
		operatorMultiplyTest.input_first_value();
		operatorMultiplyTest.tap_on_operator_multiply();
		operatorMultiplyTest.input_second_value();
		operatorMultiplyTest.tap_on_equal_button();
		operatorMultiplyTest.verify_total_value();
		operatorMultiplyTest.afterTest();
    }
}