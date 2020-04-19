package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorRandomSubtractPage;
 
public class operatorRandomSubtractTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two random vaules using subtraction.")
    public void googleCalculatorOperatorRandomSubtract () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorRandomSubtractPage operatorRandomSubtractTest = new operatorRandomSubtractPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorRandomSubtractTest.beforeTest();
		operatorRandomSubtractTest.input_first_random_value();
		operatorRandomSubtractTest.tap_on_operator_minus();
		operatorRandomSubtractTest.input_second_random_value();
		operatorRandomSubtractTest.tap_on_equal_button();
		//operatorRandomSubtractTest.verify_total_value();
		operatorRandomSubtractTest.afterTest();
    }
}