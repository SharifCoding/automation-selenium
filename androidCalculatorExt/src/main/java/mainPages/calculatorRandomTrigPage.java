package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class calculatorRandomTrigPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public calculatorRandomTrigPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********
  @Step ("Open the Android calculator advanced options.")
  public void open_pad_advanced() {
	MobileElement pad_basic = mobiledriver.findElement(CalculatorPadBasic);
	Assert.assertTrue(pad_basic.isDisplayed());
	System.out.println("Test Status: pad basic is active");
	coordinatePadAdvanced();
	MobileElement pad_advanced = mobiledriver.findElement(CalculatorPadAdvanced);
	Assert.assertTrue(pad_advanced.isDisplayed());
	System.out.println("Test Status: pad advanced is active");
  }
  
  @Step ("Select either degress or radians.")
  public void select_either_degress_or_radians() {
	MobileElement deg_rad_mode = mobiledriver.findElement(DegreeRadiansButton);
	Assert.assertTrue(deg_rad_mode.isDisplayed());
	System.out.println("Test Status: deg/rad mode button is shown");
	if (mSelectDegreesRadians.equals("DEG")) {
	  MobileElement degrees_mode = mobiledriver.findElement(DisplayDegreeRadian);
	  Assert.assertTrue(degrees_mode.isDisplayed());
	  Assert.assertEquals(degrees_mode.getText(), "DEG", "Test Status: getText assertion failed!");
	  System.out.println("Test Status: degrees mode is active");
	} else {
	  MobileElement deg_rad_button = mobiledriver.findElement(DegreeRadiansButton);
	  Assert.assertTrue(deg_rad_button.isDisplayed());
	  deg_rad_button.click();
	  MobileElement radians_mode = mobiledriver.findElement(DisplayDegreeRadian);
	  Assert.assertTrue(radians_mode.isDisplayed());
	  Assert.assertEquals(radians_mode.getText(), "RAD", "Test Status: getText assertion failed!");
	  System.out.println("Test Status: radians mode is active");
	}
  }
  
  @Step ("Input first random value for trigonometry formula.")
  public void random_first_trigonometry_value() {
	mRandomSinCosTanValue = randomSinCosTan();
	if (mRandomSinCosTanValue.equals("sin")) {
	  MobileElement sine_button = mobiledriver.findElement(SineButton);
	  Assert.assertTrue(sine_button.isDisplayed());
	  sine_button.click();
	  System.out.println("Test Status: sine button is clicked");
	} else if (mRandomSinCosTanValue.equals("cos")){
	  MobileElement cosine_button = mobiledriver.findElement(CosineButton);
	  Assert.assertTrue(cosine_button.isDisplayed());
	  cosine_button.click();
	  System.out.println("Test Status: cosine button is clicked");
	} else if (mRandomSinCosTanValue.equals("tan")){
	  MobileElement tangent_button = mobiledriver.findElement(TangentButton);
	  Assert.assertTrue(tangent_button.isDisplayed());
	  tangent_button.click();
	  System.out.println("Test Status: tangent button is clicked");
	} else {
	  System.out.println("invalid value: " + mRandomSinCosTanValue);
	}
  }
  
  @Step ("Close the Android calculator advanced options.")
  public void close_pad_advanced() {
	MobileElement pad_advanced_arrow = mobiledriver.findElement(CloseArrowButton);
	pad_advanced_arrow.click();
    System.out.println("Test Status: closed pad advanced");
  }
  
  @Step ("Input second random value for trigonometry formula.")
  public void random_second_trigonometry_value_and_execute() {
	for (char ch : Integer.toString(mRandomValue).toCharArray()) {
      int digit = ch - '0';
	  MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + digit));
	  Assert.assertTrue(digit_pad.isDisplayed());
	  digit_pad.click();
	}
    System.out.println("Test Status: inputted second value: " + mRandomValue);
	MobileElement equal_button = mobiledriver.findElement(EqualButton);
	Assert.assertTrue(equal_button.isDisplayed());
	equal_button.click();
	MobileElement get_formula = mobiledriver.findElement(DisplayResultFinal);
	String positiveString = get_formula.getText();
	positiveString = positiveString.replaceAll("[^\\d.]", "");
	mActualTotalValue = String.format("%.8f", Double.parseDouble(positiveString));
    System.out.println("Test Status: " + mSelectSinCosTan + "(" + mRandomValue + ".0) = " + mActualTotalValue);
  }
  
  @Step ("Execute basic the trigonometry test via console.")
  public void basic_trigonometry_value() {
	double degrees = mRandomValue.doubleValue();
	if (mRandomSinCosTanValue.equals("sin") || mRandomSinCosTanValue.equals("cos") || mRandomSinCosTanValue.equals("tan")){
      switch(mRandomSinCosTanValue){
	  	case "sin":
	      double radiansSin = Math.toRadians(degrees);
	      double sinValue = Math.sin(radiansSin);
	      mExpectedDegressValue = String.format("%.8f", sinValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.sin(degrees));
	      System.out.println("degrees > sin(" + degrees + ") = " + mExpectedDegressValue); 
	      System.out.println("radians > sin(" + degrees + ") = " + mExpectedRadiansValue); 
	      break;
	  	case "cos":
	      double radiansCos = Math.toRadians(degrees);
	      double cosValue = Math.cos(radiansCos);
	      mExpectedDegressValue = String.format("%.8f", cosValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.cos(degrees));
	      System.out.println("degrees > cos(" + degrees + ") = " + mExpectedDegressValue);
	      System.out.println("radians > cos(" + degrees + ") = " + mExpectedRadiansValue); 
	      break;
		case "tan":
	      double radiansTan = Math.toRadians(degrees);
	      double tanValue = Math.tan(radiansTan);
	      mExpectedDegressValue = String.format("%.8f", tanValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.tan(degrees));
	      System.out.println("degrees > tan(" + degrees + ") = " + mExpectedDegressValue);
	      System.out.println("radians > tan(" + degrees + ") = " + mExpectedRadiansValue); 
	      break;
		default :
	      System.out.println("invalid value"); 
	      break;
      }
	}
  }
  
  @Step ("Compare the actual result with the final result.")
  public void verify_trigonometry_actual_and_expected_value() {    
	if (mSelectDegreesRadians.equals("DEG")) {
		Assert.assertTrue(mExpectedDegressValue.contains(mActualTotalValue));
	    System.out.println("Test Status: total value verified: " + mActualTotalValue);
	} else {
		Assert.assertTrue(mExpectedRadiansValue.contains(mActualTotalValue));
	    System.out.println("Test Status: total value verified: " + mActualTotalValue);
	}
  }
  
  @Step ("Android calculator random trigonometry test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: android calculator random trigonometry test loaded");
  }

  @Step ("Android calculator random trigonometry test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator random trigonometry test completed");
  }
}