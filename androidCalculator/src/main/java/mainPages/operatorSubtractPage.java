package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorSubtractPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public operatorSubtractPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Input and check on first value on the Google Calculator number display.")
  public void input_first_value() {
	for (char ch : Long.toString(mSubtractSumOne).toCharArray()) {
      int digit = ch - '0';
	  MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(digit_pad.isDisplayed());
	  digit_pad.click();
	}
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mSubtractSumOne);
    Assert.assertEquals(get_formula.getText(), expected_value, "Test Status: getText assertion failed!");
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator minus button.")
  public void tap_on_operator_minus() {
	MobileElement operator_add = mobiledriver.findElement(OperatorMinusButton);
  	Assert.assertTrue(operator_add.isDisplayed());
  	operator_add.click();
    System.out.println("Test Status: tap on operator minus");
  }
  
  @Step ("Input and check on second value on the Google Calculator number display.")
  public void input_second_value() {	  
	for (char ch : Long.toString(mSubtractSumTwo).toCharArray()) {
      int digit = ch - '0';
	  MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(digit_pad.isDisplayed());
	  digit_pad.click();
	}
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
	String expected_value = Long.toString(mSubtractSumTwo);
    Assert.assertTrue(get_formula.getText().contains(expected_value));
    System.out.println("Test Status: inputed first and second values: " + get_formula.getText());
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
    System.out.println("Test Status: " + mSubtractSumOne + " - " + mSubtractSumTwo + " = " + (mSubtractSumOne - mSubtractSumTwo));
	String expected_value = Long.toString(mSubtractSumOne - mSubtractSumTwo);
	String positiveString = get_formula.getText();
	positiveString = positiveString.replaceAll("[^\\d.]", "");			
    Assert.assertTrue(expected_value.contains(positiveString));    
    System.out.println("Test Status: total value verified");
  }
  
  @Step ("Android calculator operator minus test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator operator minus test loaded");
  }

  @Step ("Android calculator operator minus test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator operator minus test completed");
  }
}