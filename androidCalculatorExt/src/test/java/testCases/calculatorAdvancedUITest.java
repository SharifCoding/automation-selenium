package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.calculatorAdvancedUIPage;
 
public class calculatorAdvancedUITest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google Android Calculator")
	@Description ("The google android calculator advanced UI are verified.")
    public void googleCalculatorOperatorSubtract () {
 
        //*************PAGE INSTANTIATIONS*************
		calculatorAdvancedUIPage calculatorAdvancedUITest = new calculatorAdvancedUIPage(mobiledriver);
 
        //*************PAGE METHODS********************
		calculatorAdvancedUITest.beforeTest();
		calculatorAdvancedUITest.verify_pad_advanced_is_shown();
		calculatorAdvancedUITest.toggle_between_degree_amd_radian_mode();
		calculatorAdvancedUITest.afterTest();
    }
}