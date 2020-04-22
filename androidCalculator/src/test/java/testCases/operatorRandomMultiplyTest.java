package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorRandomMultiplyPage;
 
public class operatorRandomMultiplyTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two random vaules using multiplication.")
    public void googleCalculatorOperatorRandomSubtract () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorRandomMultiplyPage operatorRandomMultiplyTest = new operatorRandomMultiplyPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorRandomMultiplyTest.beforeTest();
		operatorRandomMultiplyTest.input_first_random_value();
		operatorRandomMultiplyTest.tap_on_operator_multiply();
		operatorRandomMultiplyTest.input_second_random_value();
		operatorRandomMultiplyTest.tap_on_equal_button();
		operatorRandomMultiplyTest.verify_total_value();
		operatorRandomMultiplyTest.afterTest();
    }
}