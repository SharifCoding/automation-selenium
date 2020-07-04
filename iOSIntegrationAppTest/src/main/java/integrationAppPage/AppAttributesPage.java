package integrationAppPage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.qameta.allure.Step;
 
public class AppAttributesPage extends BasePage{
    
	//*********Web Page Class Constructor*********
	public AppAttributesPage(IOSDriver<IOSElement>mobiledriver) {
		BasePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********
	@Step ("Validate the launched Facebook integration iOS app.")
	public void validate_installed_app_via_xcode() {
		MobileElement main_view = mobiledriver.findElement(OtherMainView);
	  	Assert.assertTrue(main_view.isDisplayed());
		MobileElement navigation_bar = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar.isDisplayed());
		System.out.println("Test Status: launched app verified");
	}
	
	@Step ("Validate and click on the Attributes button.")
	public void click_on_the_attributes_button() {
		MobileElement button_attributes = mobiledriver.findElement(ButtonAttributes);
	  	Assert.assertTrue(button_attributes.isDisplayed());
	  	button_attributes.click();
		System.out.println("Test Status: clicked on the attributes button");
	}

	@Step ("Validate the Attributes page with the Back button.")
	public void validate_attributes_page() {
		MobileElement text_identifier = mobiledriver.findElement(TextaIdentifier);
	  	Assert.assertTrue(text_identifier.isDisplayed());
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
		System.out.println("Test Status: attributes page is loaded");
	}
	
	@Step ("Validate the first textbox will the placeholder string, clear the placeholder string, and then input the new string value.")
	public void input_validate_first_textbox() {
		MobileElement text_value = mobiledriver.findElement(TextValue);
	  	Assert.assertTrue(text_value.isDisplayed());
	  	text_value.click();
		Assert.assertEquals(text_value.getText(), mPlaceholderString);
	  	text_value.clear();
	  	text_value.sendKeys(mStringValue);
		Assert.assertEquals(text_value.getText(), mStringValue);
		System.out.println("Test Status: cleared and validated new value: " + text_value.getText());
	}
	
	@Step ("Return and validate the main page.")
	public void return_to_main_page() {
		MobileElement button_back = mobiledriver.findElement(ButtonBack);
	  	Assert.assertTrue(button_back.isDisplayed());
	  	button_back.click();
		MobileElement navigation_bar_view = mobiledriver.findElement(NavigationBarView);
	  	Assert.assertTrue(navigation_bar_view.isDisplayed());
		System.out.println("Test Status: returned to main page");
	}
	
	//*********Pre & Post Tests*********
	@BeforeTest
	public void beforeTest( ) {
		System.out.println("Test Case: alerts test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: alerts test case completed");
	}
}