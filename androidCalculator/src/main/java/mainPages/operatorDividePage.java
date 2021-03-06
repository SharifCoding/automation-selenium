package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorDividePage extends basePage{
    
  //*********Web Page Class Constructor*********
  public operatorDividePage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Input and check on first value on the Google Calculator number display.")
  public void input_first_value() {
	for (char ch : Long.toString(mDivideSumOne).toCharArray()) {
      int digit = ch - '0';
	  MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(digit_pad.isDisplayed());
	  digit_pad.click();
	}
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mDivideSumOne);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator divide button.")
  public void tap_on_operator_divide() {
	MobileElement operator_add = mobiledriver.findElement(OperatorDivideButton);
  	Assert.assertTrue(operator_add.isDisplayed());
  	operator_add.click();
    System.out.println("Test Status: tap on operator divide");
  }
  
  @Step ("Input and check on second value on the Google Calculator number display.")
  public void input_second_value() {
	for (char ch : Long.toString(mDivideSumTwo).toCharArray()) {
      int digit = ch - '0';
	  MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(digit_pad.isDisplayed());
	  digit_pad.click();
	}
  	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mDivideSumTwo);
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
	String expected_value = Double.toString(mDivideSumOne.doubleValue() / mDivideSumTwo.doubleValue());
    System.out.println("Test Status: " + mDivideSumOne + " / " + mDivideSumTwo + " = " + expected_value);
	String positiveString = get_formula.getText();
	positiveString = positiveString.replaceAll("[^\\d.]", "");			
    Assert.assertTrue(expected_value.contains(positiveString));    
    System.out.println("Test Status: total value verified");
  }
  
  @Step ("Compare the actual result with the symbolic result.")
  public void verify_total_value_two() {
	String expected_symbolic = doubleConvertToFraction(mDivideSumOne.doubleValue() / mDivideSumTwo.doubleValue());
	MobileElement get_symbolic = mobiledriver.findElement(DisplaySymbolic);
  	Assert.assertTrue(get_symbolic.isDisplayed());
    Assert.assertEquals(get_symbolic.getText(), expected_symbolic, "Test Status: getText assertion failed!");
    System.out.println("Test Status: symbolic  value verified");
  }
  
  @Step ("Android calculator operator divide test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator operator divide test loaded");
  }

  @Step ("Android calculator operator divide test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator operator divide test completed");
  }
}