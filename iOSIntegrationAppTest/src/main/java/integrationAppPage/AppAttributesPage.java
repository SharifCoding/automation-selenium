package integrationAppPage;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	@Step ("Click on the Attributes button.")
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
	
	@Step ("Get internet time and validate with the time on the app.")
	public void validate_app_timestamp() {
		String timeStampHour = new SimpleDateFormat("h").format(new Date());
		String timeStampMinute = new SimpleDateFormat("mm").format(new Date());
		String timeStamp12Hour = new SimpleDateFormat("a").format(new Date());
		System.out.println("Test Status: internet time: "
				+ timeStampHour + ":"
				+ timeStampMinute + " "
				+ timeStamp12Hour);
		MobileElement date_picker = mobiledriver.findElement(DatePicker);
		MobileElement picker_wheel_hour = mobiledriver.findElement(PickerWheelHour);
		MobileElement picker_wheel_minute = mobiledriver.findElement(PickerWheelMinute);
		MobileElement picker_wheel_12_hour = mobiledriver.findElement(PickerWheel12Hour);
	  	Assert.assertTrue(date_picker.isDisplayed());
		String parseHour[] = picker_wheel_hour.getText().split(" ");
		String parseMinute[] = picker_wheel_minute.getText().split(" ");
		System.out.println("Test Status: app time: " 
				+ parseHour[0] + ":"
				+ parseMinute[0] + " "
				+ picker_wheel_12_hour.getText());
		Assert.assertEquals(parseHour[0], timeStampHour);
		Assert.assertEquals(parseMinute[0], timeStampMinute);
		Assert.assertEquals(picker_wheel_12_hour.getText(), timeStamp12Hour);
		System.out.println("Test Status: validated app time");
	}
	
	@Step ("Input a new time value, and validate.")
	public void input_new_time_value() {
		MobileElement picker_wheel_hour = mobiledriver.findElement(PickerWheelHour);
		MobileElement picker_wheel_minute = mobiledriver.findElement(PickerWheelMinute);
		MobileElement picker_wheel_12_hour = mobiledriver.findElement(PickerWheel12Hour);
		picker_wheel_hour.setValue(mHourValue);
		picker_wheel_minute.setValue(mMinuteValue);
		picker_wheel_12_hour.setValue(m12FormatValue);
		System.out.println("Test Status: inputted new time value: "
				+ mHourValue + ":"
				+ mMinuteValue + " "
				+ m12FormatValue);
		String parseHour[] = picker_wheel_hour.getText().split(" ");
		String parseMinute[] = picker_wheel_minute.getText().split(" ");
		System.out.println("Test Status: new app time: "
				+ parseHour[0] + ":"
				+ parseMinute[0]+ " "
				+ picker_wheel_12_hour.getText());
		Assert.assertEquals(parseHour[0], mHourValue);
		Assert.assertEquals(parseMinute[0], mMinuteValue);
		Assert.assertEquals(picker_wheel_12_hour.getText(), m12FormatValue);
		System.out.println("Test Status: validated inputted time");
	}
	
	@Step ("Get internet date and validate with the app.")
	public void validate_app_timestamp_date() {
		String timeStampDayName = new SimpleDateFormat("E").format(new Date());
		String timeStampMonthInYear = new SimpleDateFormat("MMM").format(new Date());		
		String timeStampDayInMonth = new SimpleDateFormat("d").format(new Date());
		System.out.println("Test Status: internet date: "
				+ timeStampDayName + " "
				+ timeStampMonthInYear + " "
				+ timeStampDayInMonth);
		MobileElement picker_wheel_hour = mobiledriver.findElement(PickerWheelDate);
		System.out.println(picker_wheel_hour.getText());
		swipeToElement();
		System.out.println(picker_wheel_hour.getText());
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
		System.out.println("Test Case: attributes test case loaded");
	}
		
	@AfterTest
	public void afterTest( ) {
		System.out.println("Test Case: attributes test case completed");
	}
}