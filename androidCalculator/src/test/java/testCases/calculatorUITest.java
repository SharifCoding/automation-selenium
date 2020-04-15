package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorUIPage;
 
public class calculatorUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator is launched.")
    public void googleCalculatorIsLoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorUIPage androidCalculatorTest = new calculatorUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		androidCalculatorTest.beforeTest();
		androidCalculatorTest.calculator_display_is_shown();
		androidCalculatorTest.calculator_number_pad_is_shown();
		androidCalculatorTest.calculator_operator_is_shown();
		androidCalculatorTest.afterTest();
    }
}