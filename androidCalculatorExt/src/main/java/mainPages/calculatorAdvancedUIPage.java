package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
 
public class calculatorAdvancedUIPage extends basePage{
    
  //*********Web Page Class Constructor*********
  public calculatorAdvancedUIPage(AndroidDriver<MobileElement> mobiledriver) {
	basePage.mobiledriver = mobiledriver;
  }

  //*********Page Methods*********	
  @Step ("Check the Google Calculator advanced menu is shown.")
  public void verify_pad_advanced_is_shown() {
	MobileElement pad_basic = mobiledriver.findElement(CalculatorPadBasic);
  	Assert.assertTrue(pad_basic.isDisplayed());
    System.out.println("Test Status: pad basic is active");
    coordinatePadAdvanced();
	MobileElement pad_advanced = mobiledriver.findElement(CalculatorPadAdvanced);
  	Assert.assertTrue(pad_advanced.isDisplayed());
    System.out.println("Test Status: pad advanced is active");
	MobileElement pad_advanced_arrow = mobiledriver.findElement(CloseArrowButton);
	pad_advanced_arrow.click();
	isElementNotPresent(CalculatorPadAdvanced);
    System.out.println("Test Status: closed pad advanced");
  	Assert.assertFalse(!pad_advanced.isDisplayed());
    System.out.println("Test Status: pad advanced is inactive");
  }
  
  @Step ("Toggle between the Degree and Radian mode and verify on display.")
  public void toggle_between_degree_amd_radian_mode() {
	MobileElement deg_rad_display = mobiledriver.findElement(DisplayDegreeRadian);
  	Assert.assertTrue(deg_rad_display.isDisplayed());
    Assert.assertEquals(deg_rad_display.getText(), "DEG", "Test Status: getText assertion failed!");
    System.out.println("Test Status: degree and radian mode shown on display");
    coordinatePadAdvanced();
	MobileElement deg_rad_button = mobiledriver.findElement(DegreeRadiansButton);
  	Assert.assertTrue(deg_rad_button.isDisplayed());
  	deg_rad_button.click();
    Assert.assertEquals(deg_rad_display.getText(), "RAD", "Test Status: getText assertion failed!");
    System.out.println("Test Status: clicked on the degree and radian button");
	MobileElement pad_advanced_arrow = mobiledriver.findElement(CloseArrowButton);
	pad_advanced_arrow.click();
  }
  
  @Step ("Android calculator advanced UI test is loaded.")
  @BeforeTest
  public void beforeTest() {
	mobiledriver.resetApp() ;
	System.out.println("Test Case: android calculator advanced UI test loaded");
  }

  @Step ("Android calculator advanced UI test completed.")
  @AfterTest
  public void afterTest() {
    System.out.println("Test Case: android calculator advanced UI test completed");
  }
}