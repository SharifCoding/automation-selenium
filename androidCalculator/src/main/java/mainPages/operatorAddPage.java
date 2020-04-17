package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorAddPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public operatorAddPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Input and check on first value on the Google Calculator number display.")
  public void input_first_value() {
	MobileElement first_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + mAddSumOne));
  	Assert.assertTrue(first_input.isDisplayed());
  	first_input.click();
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mAddSumOne);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator add button.")
  public void tap_on_operator_add() {
	MobileElement operator_add = mobiledriver.findElement(OperatorPlusButton);
  	Assert.assertTrue(operator_add.isDisplayed());
  	operator_add.click();
    System.out.println("Test Status: tap on operator add");
  }
  
  @Step ("Input and check on second value on the Google Calculator number display.")
  public void input_second_value() {
	MobileElement second_input = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + mAddSumTwo));
  	Assert.assertTrue(second_input.isDisplayed());
  	second_input.click();
  	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mAddSumTwo);
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
    System.out.println("Test Status: " + mAddSumOne + " + " + mAddSumTwo + " = " + (mAddSumOne + mAddSumTwo));
	String expected_value = Long.toString(mAddSumOne + mAddSumTwo);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: total value verified");
  }
  
  @Step ("Android calculator operator add test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator operator add test loaded");
  }

  @Step ("Android calculator operator add test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator operator add test completed");
  }
}