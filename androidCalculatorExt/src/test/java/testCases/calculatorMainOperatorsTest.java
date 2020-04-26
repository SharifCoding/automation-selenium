package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorUIPage;
import mainPages.operatorDividePage;
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
		androidCalculatorTest.click_on_more_options();
		androidCalculatorTest.verify_more_options();
		androidCalculatorTest.click_on_device_back_button();
		androidCalculatorTest.calculator_number_pad_is_shown();
		androidCalculatorTest.verify_calculator_number_pad();
		androidCalculatorTest.calculator_operator_is_shown();
		androidCalculatorTest.verify_pad_basic_and_advanced_is_shown();
		androidCalculatorTest.afterTest();
    }
	
	@Test (priority = 1)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two vaules using subtraction.")
    public void googleCalculatorOperatorSubtract () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorSubtractPage operatorSubtractTest = new operatorSubtractPage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorSubtractTest.beforeTest();
		operatorSubtractTest.afterTest();
    }
	
	@Test (priority = 2)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("Calculating two vaules using division.")
    public void googleCalculatorOperatorDivide () {
 
        //*************PAGE INSTANTIATIONS*************
		operatorDividePage operatorDivideTest = new operatorDividePage(mobiledriver);
 
        //*************PAGE METHODS********************
		operatorDivideTest.beforeTest();
		operatorDivideTest.afterTest();
    }
}