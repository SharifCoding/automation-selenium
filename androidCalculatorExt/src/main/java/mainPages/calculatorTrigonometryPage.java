package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class calculatorTrigonometryPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public calculatorTrigonometryPage(AndroidDriver<MobileElement> mobiledriver) {
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
  
  @Step ("Input first value for trigonometry formula.")
  public void input_first_trigonometry_value() {
	if (mSelectSinCosTan.equals("sin")) {
	  MobileElement sine_button = mobiledriver.findElement(SineButton);
	  Assert.assertTrue(sine_button.isDisplayed());
	  sine_button.click();
	  System.out.println("Test Status: sine button is clicked");
	} else if (mSelectSinCosTan.equals("cos")){
	  MobileElement cosine_button = mobiledriver.findElement(CosineButton);
	  Assert.assertTrue(cosine_button.isDisplayed());
	  cosine_button.click();
	  System.out.println("Test Status: cosine button is clicked");
	} else if (mSelectSinCosTan.equals("tan")){
	  MobileElement tangent_button = mobiledriver.findElement(TangentButton);
	  Assert.assertTrue(tangent_button.isDisplayed());
	  tangent_button.click();
	  System.out.println("Test Status: tangent button is clicked");
	} else {
	  System.out.println("invalid value: " + mSelectSinCosTan);
	}
  }
  
  @Step ("Close the Android calculator advanced options.")
  public void close_pad_advanced() {
	MobileElement pad_advanced_arrow = mobiledriver.findElement(CloseArrowButton);
	pad_advanced_arrow.click();
    System.out.println("Test Status: closed pad advanced");
  }
  
  @Step ("Input second value for trigonometry formula.")
  public void input_second_trigonometry_value_and_execute() {
	MobileElement digit_pad = mobiledriver.findElement(DigitButtonsTwo);
	Assert.assertTrue(digit_pad.isDisplayed());
  	digit_pad.click();
    System.out.println("Test Status: clicked on number pad: " + mDegreesValue);
	MobileElement equal_button = mobiledriver.findElement(EqualButton);
	Assert.assertTrue(equal_button.isDisplayed());
	equal_button.click();
	MobileElement get_formula = mobiledriver.findElement(DisplayResultFinal);
	String positiveString = get_formula.getText();
	positiveString = positiveString.replaceAll("[^\\d.]", "");
	mActualTotalValue = String.format("%.8f", Double.parseDouble(positiveString));
    System.out.println("Test Status: " + mSelectSinCosTan + "(" + mDegreesValue + ") = " + mActualTotalValue);
  }
  
  @Step ("Execute basic the trigonometry test via console.")
  public void basic_trigonometry_value() {
	// https://stackoverflow.com/questions/33840516/calculator-in-java-sin-cos-tan-cot
	double degrees = mDegreesValue.doubleValue();
	if (mSelectSinCosTan.equals("sin") || mSelectSinCosTan.equals("cos") || mSelectSinCosTan.equals("tan")){
      switch(mSelectSinCosTan){
	  	case "sin":
		  // convert degrees to radians 
	      double radiansSin = Math.toRadians(degrees);
		  // sin() method to get the sine value 
	      double sinValue = Math.sin(radiansSin);
	      // prints the sine value
	      mExpectedDegressValue = String.format("%.8f", sinValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.sin(degrees));
	      System.out.println("degrees: sin(" + degrees + ") = " + mExpectedDegressValue); 
	      System.out.println("radians: sin(" + degrees + ") = " + mExpectedRadiansValue); 
	      break;
	  	case "cos":
		  // convert degrees to radians 
	      double radiansCos = Math.toRadians(degrees);
		  // cosine() method to get the cosine value 
	      double cosValue = Math.cos(radiansCos);
	      // prints the cosine value
	      mExpectedDegressValue = String.format("%.8f", cosValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.cos(degrees));
	      System.out.println("degrees: cos(" + degrees + ") = " + mExpectedDegressValue);
	      System.out.println("radians: cos(" + degrees + ") = " + mExpectedRadiansValue); 
	      break;
		case "tan":
		  // convert degrees to radians 
	      double radiansTan = Math.toRadians(degrees);
		  // tangent() method to get the tangent value 
	      double tanValue = Math.tan(radiansTan);
	      // prints the tangent value
	      mExpectedDegressValue = String.format("%.8f", tanValue);
	      mExpectedRadiansValue = String.format("%.8f", Math.tan(degrees));
	      System.out.println("degrees: tan(" + degrees + ") = " + mExpectedDegressValue);
	      System.out.println("radians: tan(" + degrees + ") = " + mExpectedRadiansValue); 
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
	    Assert.assertEquals(mActualTotalValue, mExpectedDegressValue, "Test Status: getText assertion failed!");
	    System.out.println("Test Status: total value verified: " + mActualTotalValue);
	} else {
		Assert.assertTrue(mExpectedRadiansValue.contains(mActualTotalValue));
	    System.out.println("Test Status: total value verified: " + mActualTotalValue);
	}
  }
  
  @Step ("Android calculator trigonometry test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: android calculator trigonometry test loaded");
  }

  @Step ("Android calculator trigonometry test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator trigonometry test completed");
  }
}