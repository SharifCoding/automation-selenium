package mainPages;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
 
public class readerPushContentPage extends basePage{
    
	//*********Web Page Class Constructor*********
	public readerPushContentPage(AndroidDriver<MobileElement>mobiledriver) {
		basePage.mobiledriver = mobiledriver;
	}
	
	//*********Page Methods*********	
	@Step ("Allow the device storage permission, and the R2 Reader app is loaded.")
	public void first_launch_of_the_app() {
		MobileElement content_container = mobiledriver.findElement(permission_content_container);
		Assert.assertTrue(content_container.isDisplayed());
		MobileElement allow_button = mobiledriver.findElement(permission_allow_button);
		Assert.assertTrue(allow_button.isDisplayed());
		MobileElement deny_button = mobiledriver.findElement(permission_deny_button);
		Assert.assertTrue(deny_button.isDisplayed());
		allow_button.click();
		MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
		Assert.assertTrue(r2reader_container.isDisplayed());
		System.out.println("Test Status: app is loaded");
	}
	
	@Step ("Push content to device, and then navigate to device document folder.")
	public void push_content_to_device() {
		pushContentToDevice();
		MobileElement add_book = mobiledriver.findElement(r2reader_add_book);
		Assert.assertTrue(add_book.isDisplayed());
		add_book.click();
		System.out.println("Test Status: clicked on the add book button");
		MobileElement add_content_device = mobiledriver.findElement(r2reader_add_content_device);
		Assert.assertTrue(add_content_device.isDisplayed());
		add_content_device.click();
		System.out.println("Test Status: clicked on select from your device button");
	}
	
	@Step ("Search the pushed content on the device via the document folder.")
	public void search_the_pushed_content() {
		MobileElement document_list = mobiledriver.findElement(android_document_list);
		Assert.assertTrue(document_list.isDisplayed());
		System.out.println("Test Status: android document folder is loaded");
		MobileElement document_search = mobiledriver.findElement(android_document_search);
		Assert.assertTrue(document_search.isDisplayed());
		document_search.click();
		System.out.println("Test Status: clicked on the search icon");
		MobileElement document_search_text = mobiledriver.findElement(android_document_search_text);
		Assert.assertTrue(document_search_text.isDisplayed());
		document_search_text.sendKeys(mPushContent);
		mobiledriver.pressKey(new KeyEvent(AndroidKey.ENTER));
		System.out.println("Test Status: searched: " + mPushContent);
	}
	
	@Step ("Add the pushed content, and then return to the app.")
	public void add_pushed_content_return_to_the_app() {
		MobileElement document_returned_search = mobiledriver.findElement(android_document_item_root);
		Assert.assertTrue(document_returned_search.isDisplayed());
		System.out.println("Test Status: returned search value");
		MobileElement document_returned_expected = mobiledriver.findElement(android_document_expected);
		Assert.assertTrue(document_returned_expected.isDisplayed());
		document_returned_expected.click();
		System.out.println("Test Status: clicked on the expected search value");
		MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
		Assert.assertTrue(r2reader_container.isDisplayed());
		System.out.println("Test Status: returned to the app");
	}
	
	@Step ("Verify the pushed content on the app.")
	public void verify_added_content() {
		MobileElement new_content_added = mobiledriver.findElement(r2reader_new_content_added);
		Assert.assertTrue(new_content_added.isDisplayed());
		System.out.println("Test Status: added content is verifed: " + capitaliseWord(mPushContent));
	}
	
	@Step ("Search and click on the added content to open in the Readium eReader.")
	public void click_on_the_added_content() {
		searchAndClick(capitaliseWord(mPushContent));
		MobileElement decor_content = mobiledriver.findElement(r2reader_resource_pager);
		Assert.assertTrue(decor_content.isDisplayed());
		System.out.println("Test Status: added content is loaded");
	}
	
	@Step ("Swipe a few pages and then swipe from bottom to open the eReader UI.")
	public void swipe_few_pages_and_openui() {
		swipe(DIRECTION.RIGHT);
		swipe(DIRECTION.RIGHT);
		swipe(DIRECTION.LEFT);
		swipe(DIRECTION.OPENUI);
	}
	
	@Step ("Close the Readium eReader and return to the app.")
	public void close_readium_ereader() {
		mobiledriver.navigate().back();
		MobileElement r2reader_container = mobiledriver.findElement(r2reader_action_bar_container);
		Assert.assertTrue(r2reader_container.isDisplayed());
		System.out.println("Test Status: closed the ereader");
	}
	  
	@Step ("R2 Reader push content test is loaded.")
	@BeforeTest
	public void beforeTest() {
		mobiledriver.resetApp() ;
		System.out.println("Test Case: push content test loaded");
	}
	
	@Step ("R2 Reader push content test completed.")
	@AfterTest
	public void afterTest() {
		System.out.println("Test Case: push content test completed");
	}
}