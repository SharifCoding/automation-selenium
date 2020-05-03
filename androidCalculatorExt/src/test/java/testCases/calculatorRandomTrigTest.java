package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorRandomTrigPage;
 
public class calculatorRandomTrigTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator random trigonometry test.")
    public void googleCalculatorRandomTrigonometry () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorRandomTrigPage calculatorRandomTrigTest = new calculatorRandomTrigPage(mobiledriver);
 
        //*************PAGE METHODS********************
		calculatorRandomTrigTest.beforeTest();
		calculatorRandomTrigTest.open_pad_advanced();
		calculatorRandomTrigTest.select_either_degress_or_radians();
		calculatorRandomTrigTest.random_first_trigonometry_value();
		calculatorRandomTrigTest.close_pad_advanced();
		calculatorRandomTrigTest.random_second_trigonometry_value_and_execute();
		calculatorRandomTrigTest.basic_trigonometry_value();
		calculatorRandomTrigTest.verify_trigonometry_actual_and_expected_value();
		calculatorRandomTrigTest.afterTest();
    }
}