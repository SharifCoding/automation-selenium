package mainPages;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
 
public class basePage {
	
	public static AndroidDriver<MobileElement> mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static String mAppTitle;
	public static String mAppVersion;
	public static String[] mAllContent = new String[6];
	String mActualTotalValue = "";
	String mExpectedValue = "";
	
	//*********Android Permission Mobile Elements*********
	By permission_content_container = By.id("com.android.permissioncontroller:id/content_container");
	By permission_allow_button = By.id("com.android.permissioncontroller:id/permission_allow_button");
	By permission_deny_button = By.id("com.android.permissioncontroller:id/permission_deny_button");

	//*********R2 Reader Mobile Elements*********
	By r2reader_decor_content_parent = By.id("org.readium.r2reader:id/decor_content_parent");
	By r2reader_action_bar_container = By.id("org.readium.r2reader:id/action_bar_container");
	By r2reader_action_bar_title = By.xpath("//android.widget.TextView[@index=0]");
	By r2reader_action_bar = By.id("org.readium.r2reader:id/action_bar");
	By r2reader_add_book = By.xpath("//android.widget.ImageButton[@content-desc=\"Add a Book\"]");
	
	//*********R2 More Options Mobile Elements*********
	By r2reader_more_options = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
	By r2reader_about_r2_reader = By.xpath("//android.widget.TextView[@text=\"About R2 Reader\"]");
	By r2reader_opds_feeds = By.xpath("//android.widget.TextView[@text=\"OPDS Feeds\"]");
	By r2reader_app_version = By.xpath("//android.widget.TextView[@index=1]");
	
	//*********R2 Content Mobile Elements*********
	By r2reader_content = By.id("android:id/content");
	By r2reader_card_view = By.id("org.readium.r2reader:id/card_view");
	By r2reader_all_textViews = By.className("android.widget.TextView");
	By r2reader_resource_pager = By.id("org.readium.r2reader:id/resourcePager");
	By r2reader_card_view_search = By.xpath("//android.widget.TextView[@text=\"" + mAllContent[0] + "\"]");
		
	//*********Read JSON Function*********
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	System.out.println("JSONParser: Initiating...");
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "androidR2Reader/src/test/resources/testData.json");
      	Object obj = jsonParser.parse(reader);
      	JSONArray dataInfo = (JSONArray) obj;
      	System.out.println("JSONParser: entire json --> " + dataInfo);
    	for(int i=0 ; i < dataInfo.size(); i++) 
    	{
    		JSONObject dataBlock = (JSONObject) dataInfo.get(i);
    		JSONObject data = (JSONObject) dataBlock.get("testData");
    		mAppTitle = (String) data.get("appTitle");
    		mAppVersion = (String) data.get("appVersion");
    		mAllContent[0] = (String) data.get("firstContent");
    		mAllContent[1] = (String) data.get("secondContent");
    		mAllContent[2] = (String) data.get("thirdContent");
    		mAllContent[3] = (String) data.get("fourthContent");
    		mAllContent[4] = (String) data.get("fifthContent");
    		mAllContent[5] = (String) data.get("sixthContent");
    	}
    	System.out.println("JSONParser: Ready");
    }
    
	public static boolean isElementPresent(By id) {
	    return ((mobiledriver.findElements(id).size() > 0) ? true : false);
	}
	
	//*********Get TextView Function*********
    public static void getAllText(By id) {
        List<MobileElement> list = mobiledriver.findElements(id);
        Assert.assertTrue(list.size()>0);
        for(int i = 0;i < list.size();i++) {
	        if (list.get(i).getText()!= null) {
		        String SeenText = list.get(i).getText();
		        System.out.println("Test Status: getText[" + i + "]: " + SeenText);
	        }
        }
    }
    
	//*********Search & Click on Element Function*********
    public static void searchAndClick(String searchText) {
    	MobileElement element = mobiledriver.findElement(By.xpath("//android.widget.TextView[@text=\"" + searchText + "\"]"));
    	if(element.isDisplayed()){
    	    element.click();
    	    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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