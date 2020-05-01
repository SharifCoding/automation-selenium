package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorTrigonometryPage;
 
public class calculatorTrigonometryTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator trigonometry test.")
    public void googleCalculatorTrigonometry () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorTrigonometryPage calculatorTrigonometryTest = new calculatorTrigonometryPage(mobiledriver);
 
        //*************PAGE METHODS********************
		calculatorTrigonometryTest.beforeTest();
		calculatorTrigonometryTest.open_pad_advanced();
		calculatorTrigonometryTest.select_either_degress_or_radians();
		calculatorTrigonometryTest.input_first_trigonometry_value();
		calculatorTrigonometryTest.close_pad_advanced();
		calculatorTrigonometryTest.input_second_trigonometry_value_and_execute();
		calculatorTrigonometryTest.basic_trigonometry_value();
		calculatorTrigonometryTest.verify_trigonometry_actual_and_expected_value();
		calculatorTrigonometryTest.afterTest();
    }
}