package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorMultiplyPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public operatorMultiplyPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Input and check on first value on the Google Calculator number display.")
  public void input_first_value() {
	for (char ch : Long.toString(mMultiplySumOne).toCharArray()) {
      int digit = ch - '0';
	  MobileElement first_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(first_input.isDisplayed());
	  first_input.click();
	}
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mMultiplySumOne);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator multiply button.")
  public void tap_on_operator_multiply() {
	MobileElement operator_add = mobiledriver.findElement(OperatorMultiplyButton);
  	Assert.assertTrue(operator_add.isDisplayed());
  	operator_add.click();
    System.out.println("Test Status: tap on operator multiply");
  }
  
  @Step ("Input and check on second value on the Google Calculator number display.")
  public void input_second_value() {
	for (char ch : Long.toString(mMultiplySumTwo).toCharArray()) {
      int digit = ch - '0';
	  MobileElement second_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(second_input.isDisplayed());
	  second_input.click();
	}
  	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mMultiplySumTwo);
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
  
  @Step ("Compare the actual result with the expected result.")
  public void verify_total_value() {
	MobileElement get_formula = mobiledriver.findElement(DisplayResultFinal);
    System.out.println("Test Status: " + mMultiplySumOne + " x " + mMultiplySumTwo + " = " + (mMultiplySumOne * mMultiplySumTwo));
	String expected_value = Long.toString(mMultiplySumOne * mMultiplySumTwo);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: total value verified");
  }
  
  @Step ("Android calculator operator multiply test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator operator multiply test loaded");
  }

  @Step ("Android calculator operator multiply test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator operator multiply test completed");
  }
}