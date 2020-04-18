package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorSubtractPage;
 
public class operatorSubtractTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two vaules using subtraction.")
    public void googleCalculatorOperatorSubtract () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorSubtractPage operatorSubtractTest = new operatorSubtractPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorSubtractTest.beforeTest();
		operatorSubtractTest.input_first_value();
		operatorSubtractTest.tap_on_operator_minus();
		operatorSubtractTest.input_second_value();
		operatorSubtractTest.tap_on_equal_button();
		operatorSubtractTest.verify_total_value();
		operatorSubtractTest.afterTest();
    }
}