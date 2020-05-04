package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorAdvancedUIPage;
import mainPages.calculatorBasicUIPage;
import mainPages.calculatorRandomTrigPage;
import mainPages.calculatorTrigonometryPage;
 
public class calculatorTrigonometryTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.NORMAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator is launched, and the basic UI are verified.")
    public void googleCalculatorBasicUI () {
 
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
	
	@Test (priority = 1)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator advanced UI are verified.")
    public void googleCalculatorAdvancedUI () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorAdvancedUIPage calculatorAdvancedUITest = new calculatorAdvancedUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		calculatorAdvancedUITest.beforeTest();
		calculatorAdvancedUITest.verify_pad_advanced_is_shown();
		calculatorAdvancedUITest.toggle_between_degree_amd_radian_mode();
		calculatorAdvancedUITest.afterTest();
    }
	
	@Test (priority = 2)
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
	
	@Test (priority = 3)
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