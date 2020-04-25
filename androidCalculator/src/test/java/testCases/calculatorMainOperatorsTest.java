package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorUIPage;
import mainPages.operatorAddPage;
import mainPages.operatorDividePage;
import mainPages.operatorMultiplyPage;
import mainPages.operatorSubtractPage;
 
public class calculatorMainOperatorsTest extends baseTest{
	
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
	@Description ("Calculating two vaules using addition.")
    public void googleCalculatorOperatorAdd () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorAddPage operatorAddTest = new operatorAddPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorAddTest.beforeTest();
		operatorAddTest.input_first_value();
		operatorAddTest.tap_on_operator_add();
		operatorAddTest.input_second_value();
		operatorAddTest.tap_on_equal_button();
		operatorAddTest.verify_total_value();
		operatorAddTest.afterTest();
    }
	
	@Test (priority = 2)
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
	
	@Test (priority = 3)
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
	
	@Test (priority = 4)
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