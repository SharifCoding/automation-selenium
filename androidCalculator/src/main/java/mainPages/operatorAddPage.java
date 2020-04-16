package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class operatorAddPage extends basePage{
	
  //*********Web Elements*********
  By OperatorAddButton = By.id("com.google.android.calculator:id/op_add");
  By EqualButton = By.id("com.google.android.calculator:id/eq");
  By DisplayFormula = By.id("com.google.android.calculator:id/formula");
  By DisplayResultFinal = By.id("com.google.android.calculator:id/result_final");
  
  //*********Web Elements*********
  By DigitOneButton = By.id("com.google.android.calculator:id/digit_1");
  By DigitTwoButton = By.id("com.google.android.calculator:id/digit_2");
  By DigitThreeButton = By.id("com.google.android.calculator:id/digit_3");
  By DigitFourButton = By.id("com.google.android.calculator:id/digit_4");
  By DigitFiveButton = By.id("com.google.android.calculator:id/digit_5");
  By DigitSixButton = By.id("com.google.android.calculator:id/digit_6");
  By DigitSevenButton = By.id("com.google.android.calculator:id/digit_7");
  By DigitEightButton = By.id("com.google.android.calculator:id/digit_8");
  By DigitNineButton = By.id("com.google.android.calculator:id/digit_9");
  By DigitZeroButton = By.id("com.google.android.calculator:id/digit_0");
    
  //*********Web Page Class Constructor*********
  public operatorAddPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Tap and check on the Google Calculator number three button.")
  public void input_first_value() {
	MobileElement digit_three = mobiledriver.findElement(DigitThreeButton);
  	Assert.assertTrue(digit_three.isDisplayed());
  	digit_three.click();
	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
    System.out.println("Test Status: input first value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator add button.")
  public void tap_on_operator_add() {
	MobileElement operator_add = mobiledriver.findElement(OperatorAddButton);
  	Assert.assertTrue(operator_add.isDisplayed());
  	operator_add.click();
    System.out.println("Test Status: tap on operator add");
  }
  
  @Step ("Check and tap on the Google Calculator number six button.")
  public void input_second_value() {
	MobileElement digit_six = mobiledriver.findElement(DigitSixButton);
  	Assert.assertTrue(digit_six.isDisplayed());
  	digit_six.click();
  	MobileElement get_formula = mobiledriver.findElement(DisplayFormula);
    System.out.println("Test Status: input second value: " + get_formula.getText());
  }
  
  @Step ("Check and tap on the Google Calculator operator equal button.")
  public void tap_on_equal_button() {
	MobileElement operator_equal = mobiledriver.findElement(EqualButton);
  	Assert.assertTrue(operator_equal.isDisplayed());
  	operator_equal.click();
    System.out.println("Test Status: tap on equal button");
  }
  
  @Step ("Check and tap on the Google Calculator operator equal button.")
  public void verify_total_value() {
	MobileElement get_formula = mobiledriver.findElement(DisplayResultFinal);
    System.out.println("Test Status: value one + value two = " + get_formula.getText());
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