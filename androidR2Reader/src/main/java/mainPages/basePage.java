package mainPages;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

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
	By r2reader_more_options = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
	By r2reader_content = By.id("android:id/content");
	By r2reader_card_view = By.id("org.readium.r2reader:id/card_view");
	By r2reader_add_book = By.xpath("//android.widget.ImageButton[@content-desc=\"Add a Book\"]");
	
	//*********R2 More Options Mobile Elements*********
	By r2reader_about_r2_reader = By.xpath("//android.widget.TextView[@text=\"About R2 Reader\"]");
	By r2reader_opds_feeds = By.xpath("//android.widget.TextView[@text=\"OPDS Feeds\"]");
	By r2reader_app_version = By.xpath("//android.widget.TextView[@index=1]");
	
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
    	}
    	System.out.println("JSONParser: Ready");
    }
    
    // https://stackoverflow.com/questions/51018055/how-to-scroll-up-in-android-appium
    public void scrollToBottom() {
        int startX = mobiledriver.manage().window().getSize().width / 2;
        int startY = (int) (mobiledriver.manage().window().getSize().height * 0.7);
        int endY = (int) (mobiledriver.manage().window().getSize().height * 0.3);
        new TouchAction<>(mobiledriver)
	      .press(PointOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	      .moveTo(PointOption.point(startX, endY))
	      .release()
          .perform();
    }
}