package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorRandomDividePage extends basePage{

  //*********Web Page Class Constructor*********
  public operatorRandomDividePage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Input and check on first random value on the Google Calculator number display.")
  public void input_first_random_value() { 
	MobileElement first_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + mDivideRandomOne));
  	Assert.assertTrue(first_input.isDisplayed());
  	first_input.click();
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = String.valueOf(mDivideRandomOne);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator divide button.")
  public void tap_on_operator_divide() {
	MobileElement operator_divide = mobiledriver.findElement(OperatorDivideButton);
  	Assert.assertTrue(operator_divide.isDisplayed());
  	operator_divide.click();
    System.out.println("Test Status: tap on operator divide");
  }
  
  @Step ("Input and check on second random value on the Google Calculator number display.")
  public void input_second_random_value() {
	MobileElement second_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + mDivideRandomTwo));
  	Assert.assertTrue(second_input.isDisplayed());
  	second_input.click();
  	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = String.valueOf(mDivideRandomTwo);
    Assert.assertTrue(get_formula.getText().contains(expected_value));
    System.out.println("Test Status: input second value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator equal button.")
  public void tap_on_equal_button() {
	MobileElement operator_equal = mobiledriver.findElement(EqualButton);
  	Assert.assertTrue(operator_equal.isDisplayed());
  	operator_equal.click();
    System.out.println("Test Status: tap on equal button");
  }
  
  @Step ("Compare the actual result with the final result.")
  public void verify_total_value_one() {
	MobileElement get_formula = mobiledriver.findElement(DisplayResultFinal);
	String expected_value = Double.toString(mDivideRandomOne.doubleValue() / mDivideRandomTwo.doubleValue());
    System.out.println("Test Status: " + mDivideRandomOne + " / " + mDivideRandomTwo + " = " + expected_value);
	Assert.assertTrue(expected_value.contains(get_formula.getText()));
    System.out.println("Test Status: total value verified: " + get_formula.getText());
  }
  
  @Step ("Compare the actual result with the symbolic result.")
  public void verify_total_value_two() {
    // Double convert to Fraction - https://stackoverflow.com/questions/35031139/double-convert-to-fraction
    double doubleVal = mDivideRandomOne.doubleValue() / mDivideRandomTwo.doubleValue();
    double negligibleRatio = 0.01;
	String expected_symbolic;
    for(int i=1;;i++){
    	double tem = doubleVal/(1D/i);
        if(Math.abs(tem-Math.round(tem))<negligibleRatio){
        	expected_symbolic = Math.round(tem)+"⁄"+i;
            break;
        }
    }
	MobileElement get_symbolic = mobiledriver.findElement(DisplaySymbolic);
  	Assert.assertTrue(get_symbolic.isDisplayed());
    Assert.assertEquals(get_symbolic.getText(), expected_symbolic, "Test Status: getText assertion failed!");
    System.out.println("Test Status: symbolic  value verified: " + get_symbolic.getText());
  }
  
  @Step ("Android calculator operator random divide test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator operator random divide test loaded");
  }

  @Step ("Android calculator operator random divide test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator operator random divide test completed");
  }
}