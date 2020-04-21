package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorDividePage;
 
public class operatorDivideTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two vaules using division.")
    public void googleCalculatorOperatorDivide () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorDividePage operatorDivideTest = new operatorDividePage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorDivideTest.beforeTest();
		operatorDivideTest.input_first_value();
		operatorDivideTest.tap_on_operator_divide();
		operatorDivideTest.input_second_value();
		operatorDivideTest.tap_on_equal_button();
		operatorDivideTest.verify_total_value_one();
		operatorDivideTest.verify_total_value_two();
		operatorDivideTest.afterTest();
    }
}