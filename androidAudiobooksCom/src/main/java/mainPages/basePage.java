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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	//*********Audiobooks Main Mobile Elements*********
	By audiobooks_main_content = By.id("android:id/content");
	By audiobooks_main_toolbar = By.id("com.audiobooks.androidapp:id/main_toolbar");
	By audiobooks_featured_titles = By.xpath("//android.widget.TextView[@text=\"Featured Titles\"]");
	By audiobooks_txt_version = By.id("com.audiobooks.androidapp:id/txt_version");

	//*********Audiobooks Menu Mobile Elements*********
	By audiobooks_menu_open = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu Open\"]");
	By audiobooks_menu_audiobooks_titles = By.xpath("//android.widget.TextView[@text=\"Audiobooks\"]");
	By audiobooks_settings_menu_item = By.id("com.audiobooks.androidapp:id/settings_menu_item");
	By audiobooks_menu_settings_titles = By.xpath("//android.widget.TextView[@text=\"Settings\"]");
	By audiobooks_featured_menu_item = By.id("com.audiobooks.androidapp:id/featured_menu_item");
	
	//*********Audiobooks Search Mobile Elements*********
	By audiobooks_main_search_icon_one = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");
	By audiobooks_main_search_field = By.id("com.audiobooks.androidapp:id/txt_search_action_bar");
	By audiobooks_main_search_empty = By.xpath("//android.widget.EditText[@text=\"Search Term\"]");
	By audiobooks_main_search_icon_two = By.xpath("//android.widget.ImageView[@content-desc=\"Search\"]");
	
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
    	}
    	System.out.println("JSONParser: Ready");
    }
    
	//*********Boolean isElementPresent Function*********
	public static boolean isElementPresent(By id) {
	    return ((mobiledriver.findElements(id).size() > 0) ? true : false);
	}
	
	//*********invisibilityOfElementLocated Function*********
    public static void waitElementNotPresent(By id, int time) {
    	new WebDriverWait(mobiledriver, time).until(ExpectedConditions.invisibilityOfElementLocated(id));
    }
    
	//*********Search & Click on Element Function*********
    public static void scrollMenu(String scrollIntoView) {
        mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
           	+ ".resourceId(\"com.audiobooks.androidapp:id/menu_layout\")).scrollIntoView("+ "new UiSelector()"
            + ".resourceId(\"com.audiobooks.androidapp:id/" + scrollIntoView + "\"))");
        System.out.println("Test Status: scrollIntoView: " + scrollIntoView);
    }
    
	//*********Provided Coordinate Tap Function*********
    public static void coordinateTouchAction(double width, double height) {
        Dimension size = mobiledriver.manage().window().getSize();
        int xOffset_pad_advanced = (int) (size.getWidth() * width);
        int yOffset_pad_advanced = (int) (size.getHeight() * height);
        new TouchAction<>(mobiledriver).tap(PointOption.point(xOffset_pad_advanced, yOffset_pad_advanced)).perform();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
	//*********Declare Swipe Direction*********
	public enum DIRECTION{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
	//*********Swipe From and To Function*********
	public static void swipe(DIRECTION direction){
	    Dimension size = mobiledriver.manage().window().getSize();
		int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;
	    
		try {
			switch(direction){
			case UP:
		        startX = (int) (size.width / 2);
		        startY = (int) (size.height * 0.3);
		        endY = (int) (size.height * 0.7);
		        new TouchAction<>(mobiledriver)
		        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		        	.moveTo(PointOption.point(startX, endY))
		        	.release()
		        	.perform();
		        System.out.println("Swipe Status: swiped from bottom to top");
		        break;
			case DOWN:
		        startX = (int) (size.width / 2);
		        startY = (int) (size.height * 0.7);
		        endY = (int) (size.height * 0.3);
		        new TouchAction<>(mobiledriver)
		        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		        	.moveTo(PointOption.point(startX, endY))
		        	.release()
		        	.perform();
		        System.out.println("Swipe Status: swiped from top to bottom");
				break;
			case LEFT:
				startY = (int) (mobiledriver.manage().window().getSize().height / 2);
	            startX = (int) (mobiledriver.manage().window().getSize().width * 0.1);
	            endX = (int) (mobiledriver.manage().window().getSize().width * 0.9);
		        new TouchAction<>(mobiledriver)
		        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				    .moveTo(PointOption.point(endX, startY))
	                .release()
	                .perform();
		        System.out.println("Swipe Status: swiped from right to left");
				break;
			case RIGHT:
				startY = (int) (mobiledriver.manage().window().getSize().height / 2);
	            startX = (int) (mobiledriver.manage().window().getSize().width * 0.9);
	            endX = (int) (mobiledriver.manage().window().getSize().width * 0.1);
		        new TouchAction<>(mobiledriver)
		        	.press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				    .moveTo(PointOption.point(endX, startY))
	                .release()
	                .perform();
		        System.out.println("Swipe Status: swiped from left to right");
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}