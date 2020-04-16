package mainPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class calculatorUIPage extends basePage{
	
  //*********Web Elements*********
  By CalculatorToolbar = By.id("com.google.android.calculator:id/toolbar");
  By CalculatorDisplay = By.id("com.google.android.calculator:id/display");
  By CalculatorPadNumeric = By.id("com.google.android.calculator:id/pad_numeric");
  By CalculatorPadOperator = By.id("com.google.android.calculator:id/pad_operator");
    
  //*********Web Page Class Constructor*********
  public calculatorUIPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Toolbar triggered on launch for the Google Calculator.")
  public void calculator_toolbar_is_shown() {
	MobileElement toolbar = mobiledriver.findElement(CalculatorToolbar);
  	Assert.assertTrue(toolbar.isDisplayed());
    System.out.println("Test Status: calculator toolbar is shown");
  }
  
  @Step ("Check the Google Calculator display is shown.")
  public void calculator_display_is_shown() {
	MobileElement display = mobiledriver.findElement(CalculatorDisplay);
  	Assert.assertTrue(display.isDisplayed());
    System.out.println("Test Status: calculator display is shown");
  }
  
  @Step ("Check the Google Calculator number pad is shown.")
  public void calculator_number_pad_is_shown() {
	MobileElement display = mobiledriver.findElement(CalculatorPadNumeric);
  	Assert.assertTrue(display.isDisplayed());
    System.out.println("Test Status: calculator number pad is shown");
  }
  
  @Step ("Check the Google Calculator operator is shown.")
  public void calculator_operator_is_shown() {
	MobileElement display = mobiledriver.findElement(CalculatorPadOperator);
  	Assert.assertTrue(display.isDisplayed());
    System.out.println("Test Status: calculator operator is shown");
  }
  
  @Step ("Android calculator UI test is loaded.")
  @BeforeTest
  public void beforeTest() {
	System.out.println("Test Case: android calculator UI test loaded");
  }

  @Step ("Android calculator UI test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator UI test completed");
  }
}