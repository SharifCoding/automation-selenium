package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorRandomDividePage;
 
public class operatorRandomDivideTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two random vaules using division.")
    public void googleCalculatorOperatorRandomDivision () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorRandomDividePage operatorRandomDivideTest = new operatorRandomDividePage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorRandomDivideTest.beforeTest();
		operatorRandomDivideTest.input_first_random_value();
		operatorRandomDivideTest.tap_on_operator_divide();
		operatorRandomDivideTest.input_second_random_value();
		operatorRandomDivideTest.tap_on_equal_button();
		operatorRandomDivideTest.verify_total_value_one();
		operatorRandomDivideTest.verify_total_value_two();
		operatorRandomDivideTest.afterTest();
    }
}