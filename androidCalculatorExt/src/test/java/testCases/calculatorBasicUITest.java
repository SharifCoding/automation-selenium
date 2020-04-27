package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorBasicUIPage;
 
public class calculatorBasicUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator is launched, and the basic UI are verified.")
    public void googleCalculatorIsLoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorBasicUIPage androidCalculatorTest = new calculatorBasicUIPage(mobiledriver);
 
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
		androidCalculatorTest.afterTest();
    }
}