package mainPages;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class calculatorBasicUIPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public calculatorBasicUIPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Toolbar tip triggered on launch for the Google Calculator.")
  public void calculator_toolbar_is_shown() {
	MobileElement toolbar_tip = mobiledriver.findElement(CalculatorToolbar);
  	Assert.assertTrue(toolbar_tip.isDisplayed());
    System.out.println("Test Status: calculator toolbar tip is shown");
  }
  
  @Step ("Check the Google Calculator display is shown.")
  public void calculator_display_is_shown() {
	MobileElement display = mobiledriver.findElement(CalculatorDisplay);
  	Assert.assertTrue(display.isDisplayed());
    System.out.println("Test Status: calculator display is shown");
  }
  
  @Step ("Click on More Options button to display additional menu.")
  public void click_on_more_options() {
	MobileElement moreoptions = mobiledriver.findElement(MoreOptionsButton);
  	Assert.assertTrue(moreoptions.isDisplayed());
  	moreoptions.click();
    System.out.println("Test Status: more options button is clicked");
  }
  
  @Step ("Verify following More Options; History, Choose Theme, Send Feedback, and Help.")
  public void verify_more_options() {
	MobileElement option_history = mobiledriver.findElement(OptionHistory);
  	Assert.assertTrue(option_history.isDisplayed());
    System.out.println("Test Status: option history is shown");
	MobileElement choose_theme = mobiledriver.findElement(OptionChooseTheme);
  	Assert.assertTrue(choose_theme.isDisplayed());
    System.out.println("Test Status: option choose theme is shown");  
	MobileElement send_feedback = mobiledriver.findElement(OptionSendFeedback);
  	Assert.assertTrue(send_feedback.isDisplayed());
    System.out.println("Test Status: option send feedback is shown");
	MobileElement help = mobiledriver.findElement(OptionHelp);
  	Assert.assertTrue(help.isDisplayed());
    System.out.println("Test Status: option help is shown");
  }
  
  @Step ("Click on the device back button to close option menu.")
  public void click_on_device_back_button() {
	mobiledriver.navigate().back();
    System.out.println("Test Status: clicked on device back button");
  }
  
  @Step ("Check the Google Calculator number pad is shown.")
  public void calculator_number_pad_is_shown() {
	MobileElement number_pad = mobiledriver.findElement(CalculatorPadNumeric);
  	Assert.assertTrue(number_pad.isDisplayed());
    System.out.println("Test Status: calculator number pad is shown");
  }
  
  @Step ("Verify each Google Calculator number buttons.")
  public void verify_calculator_number_pad() {
    for (int loopDigit = 0; loopDigit < 10; loopDigit++) {
      MobileElement digit_pad = mobiledriver.findElement(By.id("com.google.android.calculator:id/digit_" + loopDigit));
  	  Assert.assertTrue(digit_pad.isDisplayed());
      System.out.println("Test Status: verified number pad: " + loopDigit);
    }
    System.out.println("Test Status: calculator number pad verified");
  }
  
  @Step ("Check the Google Calculator operator is shown.")
  public void calculator_operator_is_shown() {
	MobileElement operator = mobiledriver.findElement(CalculatorPadOperator);
  	Assert.assertTrue(operator.isDisplayed());
    System.out.println("Test Status: calculator operator is shown");
  }
  
  @Step ("Android calculator basic UI test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: android calculator basic UI test loaded");
  }

  @Step ("Android calculator basic UI test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator basic UI test completed");
  }
}