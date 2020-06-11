package mainPages;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class basePage {
	
	public static AndroidDriver<MobileElement>mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static String mAppTitle;
	public static String mAppVersion;
	public static String mSearchString;
	public static String mFirstShelveTitle;
	public static String mFirstShelveContent;
	public static String mSecondShelveTitle;
	public static String mSecondShelveContent;
	public static String mThirdShelveTitle;
	public static String mThirdShelveContent;
	public static String mRandomShelveTitle;
	public static String mRandomShelveContent;
	public static String mRandomBrowseOption;

	//*********Audiobooks Main Mobile Elements*********
	By audiobooks_main_content = By.id("android:id/content");
	By audiobooks_main_toolbar = By.id("com.audiobooks.androidapp:id/main_toolbar");
	By audiobooks_featured_titles = By.xpath("//android.widget.TextView[@text=\"Featured Titles\"]");
	By audiobooks_browse_titles = By.xpath("//android.widget.TextView[@text=\"Browse Books\"]");
	By audiobooks_txt_version = By.id("com.audiobooks.androidapp:id/txt_version");

	//*********Audiobooks Menu Mobile Elements*********
	By audiobooks_menu_open = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu Open\"]");
	By audiobooks_menu_audiobooks_titles = By.xpath("//android.widget.TextView[@text=\"Audiobooks\"]");
	By audiobooks_settings_menu_item = By.id("com.audiobooks.androidapp:id/settings_menu_item");
	By audiobooks_menu_settings_titles = By.xpath("//android.widget.TextView[@text=\"Settings\"]");
	By audiobooks_featured_menu_item = By.id("com.audiobooks.androidapp:id/featured_menu_item");
	By audiobooks_browse_menu_item = By.id("com.audiobooks.androidapp:id/browse_menu_item");
	
	//*********Audiobooks Search Mobile Elements*********
	By audiobooks_search_icon_one = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");
	By audiobooks_search_field = By.id("com.audiobooks.androidapp:id/txt_search_action_bar");
	By audiobooks_search_empty = By.xpath("//android.widget.EditText[@text=\"Search Term\"]");
	By audiobooks_search_icon_two = By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]");
	By audiobooks_search_result_text = By.id("com.audiobooks.androidapp:id/search_result_text");
	By audiobooks_title = By.id("com.audiobooks.androidapp:id/title");
	By audiobooks_book_list_item_layout = By.id("com.audiobooks.androidapp:id/book_list_item_layout");
	
	//*********Audiobooks Details Mobile Elements*********
	By audiobooks_book_details_view = By.id("com.audiobooks.androidapp:id/bookDetailsView");
	By audiobooks_book_play_icon = By.id("com.audiobooks.androidapp:id/play_image");
	
	//*********Audiobooks Player Mobile Elements*********
	By audiobooks_now_playing_panel = By.id("com.audiobooks.androidapp:id/now_playing_panel");
	By audiobooks_now_playing_title = By.id("com.audiobooks.androidapp:id/now_playing_title");
	By audiobooks_now_playing_button = By.id("com.audiobooks.androidapp:id/now_playing_button");
	By audiobooks_book_nav_controls = By.id("com.audiobooks.androidapp:id/book_nav_controls");
	By audiobooks_play_pause_layout = By.id("com.audiobooks.androidapp:id/play_pause_layout");
	
	//*********Audiobooks Browse Mobile Elements*********
	By audiobooks_menu_browse_option = By.xpath("//android.widget.TextView[@text=\"" + mRandomBrowseOption + "\"]");

	//*********Read JSON Function*********
	public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
		System.out.println("JSONParser: Initiating...");
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(myPath + "androidAudiobooksCom/src/test/resources/testData.json");
		Object obj = jsonParser.parse(reader);
		JSONArray dataInfo = (JSONArray) obj;
		System.out.println("JSONParser: entire json --> " + dataInfo);
		for(int i=0; i < dataInfo.size(); i++) 
		{
			JSONObject dataBlock = (JSONObject) dataInfo.get(i);
			JSONObject data = (JSONObject) dataBlock.get("testData");
			mAppTitle = (String) data.get("appTitle");
			mAppVersion = (String) data.get("appVersion");
			mSearchString = (String) data.get("searchString");
			mFirstShelveTitle = (String) data.get("firstShelveTitle");
			mFirstShelveContent = (String) data.get("firstShelveContent");
			mSecondShelveTitle = (String) data.get("secondShelveTitle");
			mSecondShelveContent = (String) data.get("secondShelveContent");
			mThirdShelveTitle = (String) data.get("thirdShelveTitle");
			mThirdShelveContent = (String) data.get("thirdShelveContent");
			mRandomShelveTitle = (String) data.get("randomShelveTitle");
			mRandomShelveContent = (String) data.get("randomShelveContent");
			mRandomBrowseOption = (String) data.get("randomBrowseOption");
		}
		System.out.println("JSONParser: Ready");
	}
    
	//*********Scroll and Search Menu Function*********
	public static void scrollMenu(String scrollIntoView) {
		mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
			+ ".resourceId(\"com.audiobooks.androidapp:id/menu_layout\")).scrollIntoView(new UiSelector()"
			+ ".resourceId(\"com.audiobooks.androidapp:id/" + scrollIntoView + "\"))");
		System.out.println("Test Status: scrollIntoView: " + scrollIntoView);
	}
	
	//*********Scroll Vertical To Text Function*********
	public void scrollToShelve(String visibleText) {
		try {
			mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()"
				+ ".textContains(\"" + visibleText + "\").instance(0))");
			System.out.println("Test Status: scrolled to shelve: " + visibleText);
		 }catch (Exception e){
			System.out.println("Test Status: shelve not found");
		}
	}
	
	//*********Scroll Vertical To Instance Function*********	
	public static MobileElement scrollAndCheckShelve(String instanceNumber) {
		try {
		    String scrollableList="com.audiobooks.androidapp:id/txt_title";
			MobileElement element = mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
					+ ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()"
					+ ".resourceId(\"" + scrollableList + "\").instance(" + instanceNumber + "))");
			return element;
		 }catch (Exception e){
			System.out.println("Test Status: shelve not found");
			return null;
		}
	}
	
	//*********Scroll Horizontal Function*********
	public void scrollHorizontal(String visibleText) {
		mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
			+ ".resourceId(\"com.audiobooks.androidapp:id/list\"))"
	        + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\"))");
	}
	
	//*********Scroll and Check Content Function*********
	public static void scrollAndCheckContent(String instanceNumber, String visibleText) {
		try {
		    String scrollableList="com.audiobooks.androidapp:id/list";
		    mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
					+ ".resourceId(\"" + scrollableList + "\").instance(" + instanceNumber + "))"
			        + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\"))");
			System.out.println("Test Status: expected content found: " + visibleText);
		 }catch (Exception e){
			System.out.println("Test Status: content not found: " + visibleText);
		}
	}
	  
	//*********Declare Swipe Direction*********
		public enum DIRECTION{
			Quick_Swipe_Down,
			Swipe_Up
		}
		
		//*********Swipe From and To Function*********
		public static void swipe(DIRECTION direction){
		    Dimension size = mobiledriver.manage().window().getSize();
			int startX = 0;
		    int startY = 0;
		    int endY = 0;
		    
			try {
				switch(direction){
				case Quick_Swipe_Down:
			        startX = (int) (size.width / 2);
			        startY = (int) (size.height * 0.6);
			        endY = (int) (size.height * 0.4);
			        new TouchAction<>(mobiledriver)
			        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			        	.moveTo(PointOption.point(startX, endY))
			        	.release()
			        	.perform();
			        System.out.println("Test Status: quickly swiped down");
					break;
				case Swipe_Up:
			        startX = (int) (size.width / 2);
			        startY = (int) (size.height * 0.3);
			        endY = (int) (size.height * 0.7);
			        new TouchAction<>(mobiledriver)
			        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
			        	.moveTo(PointOption.point(startX, endY))
			        	.release()
			        	.perform();
			        System.out.println("Test Status: quickly swiped up");
					break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}