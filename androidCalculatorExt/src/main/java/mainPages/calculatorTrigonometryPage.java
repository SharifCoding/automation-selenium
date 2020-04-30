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
    System.out.println("Test Status: " + mSelectSinCosTan + "(" + mDegreesValue + ") = " + get_formula.getText());
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
	      System.out.println("degrees: sin(" + degrees + ") = " + sinValue); 
	      System.out.println("radians: sin(" + degrees + ") = " + Math.sin(degrees)); 
	      break;
	  	case "cos":
		  // convert degrees to radians 
	      double radiansCos = Math.toRadians(degrees);
		  // cosine() method to get the cosine value 
	      double cosValue = Math.cos(radiansCos);
	      // prints the cosine value 
	      System.out.println("degrees: cos(" + degrees + ") = " + cosValue);
	      System.out.println("radians: cos(" + degrees + ") = " + Math.cos(degrees)); 
	      break;
		case "tan":
		  // convert degrees to radians 
	      double radiansTan = Math.toRadians(degrees);
		  // tangent() method to get the tangent value 
	      double tanValue = Math.tan(radiansTan);
	      // prints the tangent value 
	      System.out.println("degrees: tan(" + degrees + ") = " + tanValue);
	      System.out.println("radians: tan(" + degrees + ") = " + Math.tan(degrees)); 
	      break;
		default :
	      System.out.println("invalid value"); 
	      break;
      }
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