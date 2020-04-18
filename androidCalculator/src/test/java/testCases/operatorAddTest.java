package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.operatorAddPage;
 
public class operatorAddTest extends baseTest{
	
	@Test (priority = 0)
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
}