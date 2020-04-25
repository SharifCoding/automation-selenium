package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorUIPage;
import mainPages.operatorRandomAddPage;
import mainPages.operatorRandomDividePage;
import mainPages.operatorRandomMultiplyPage;
import mainPages.operatorRandomSubtractPage;
 
public class calculatorRandomNumbersTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator is launched.")
    public void googleCalculatorIsLoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorUIPage androidCalculatorTest = new calculatorUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		androidCalculatorTest.beforeTest();
		androidCalculatorTest.calculator_toolbar_is_shown();
		androidCalculatorTest.calculator_display_is_shown();
		androidCalculatorTest.calculator_number_pad_is_shown();
		androidCalculatorTest.calculator_operator_is_shown();
		androidCalculatorTest.afterTest();
    }
	
	@Test (priority = 1)
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
	
	@Test (priority = 2)
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
		operatorRandomSubtractTest.verify_total_value();
		operatorRandomSubtractTest.afterTest();
    }
	
	@Test (priority = 3)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two random vaules using multiplication.")
    public void googleCalculatorOperatorRandomMultiply () {
 
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
	
	@Test (priority = 4)
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