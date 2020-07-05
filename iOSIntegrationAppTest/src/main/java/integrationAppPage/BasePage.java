package integrationAppPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
 
public class BasePage {

	public static IOSDriver<IOSElement>mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static String mTableValue = "";
	public static String mScrollValue = "";
	public static String mStringValue = "";
	public static String mPlaceholderString = "Value";
    
	//*********Main Mobile Elements*********
	By OtherMainView = By.xpath("//XCUIElementTypeOther[@name=\"MainView\"]");
	By NavigationBarView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"View\"]");
	By ButtonAlerts = By.xpath("//XCUIElementTypeButton[@name=\"Alerts\"]");
	By ButtonDeadlock = By.xpath("//XCUIElementTypeButton[@name=\"Deadlock app\"]");
	By ButtonAttributes = By.xpath("//XCUIElementTypeButton[@name=\"Attributes\"]");
	By ButtonScrolling = By.xpath("//XCUIElementTypeButton[@name=\"Scrolling\"]");
	By TextPortrait = By.xpath("//XCUIElementTypeStaticText[@name=\"Portrait\"]");
	By TextLandscape = By.xpath("//XCUIElementTypeStaticText[@name=\"LandscapeRight\"]");
	By NavigationBarUIView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"UIView\"]");
	By ButtonBack = By.xpath("//XCUIElementTypeButton[@name=\"Back\"]");
	
	//*********Alerts Mobile Elements*********
	By NavigationBarFBAlertView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"FBAlertView\"]");
	By TextField = By.xpath("//XCUIElementTypeTextField[@name=\"textField\"]");
	By ButtonCreateAppAlert = By.xpath("//XCUIElementTypeButton[@name=\"Create App Alert\"]");
	By TextMagic = By.xpath("//XCUIElementTypeStaticText[@name=\"Magic\"]");
	By ButtonWillDo = By.xpath("//XCUIElementTypeButton[@name=\"Will do\"]");
	
	//*********Attributes Mobile Elements*********
	By TextValue = By.xpath("//XCUIElementTypeTextField[@value=\"Value\"]");
	By TextaIdentifier = By.xpath("//XCUIElementTypeTextField[@name=\"aIdentifier\"]");
	By DatePicker = By.xpath("//XCUIElementTypeDatePicker[@enabled=\"true\"]");
	By PickerWheelHour = By.xpath("//XCUIElementTypePickerWheel[@enabled=\"true\"][2]");
	By PickerWheelMinute = By.xpath("//XCUIElementTypePickerWheel[@enabled=\"true\"][3]");
	
	//*********Scrolling Mobile Elements*********
	By ButtonTableView = By.xpath("//XCUIElementTypeButton[@name=\"TableView\"]");
	By ButtonScrollView = By.xpath("//XCUIElementTypeButton[@name=\"ScrollView\"]");
	By NavigationBarUITableView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"UITableView\"]");
	By UITableViewValue = By.xpath("//XCUIElementTypeStaticText[@name=\""+ mTableValue +"\"]");
	By NavigationBarFBScrollView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"FBScrollView\"]");
	By UIScrollViewValue = By.xpath("//XCUIElementTypeStaticText[@name=\""+ mScrollValue +"\"]");
	
	//*********Read JSON Function*********
	public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
		System.out.println("JSONParser: Initiating...");
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(myPath + "iOSIntegrationAppTest/src/test/resources/testData.json");
		Object obj = jsonParser.parse(reader);
		JSONArray dataInfo = (JSONArray) obj;
		System.out.println("JSONParser: entire json --> " + dataInfo);
		for(int i=0; i < dataInfo.size(); i++) 
		{
			JSONObject dataBlock = (JSONObject) dataInfo.get(i);
			JSONObject data = (JSONObject) dataBlock.get("testData");
			mStringValue = (String) data.get("stringValue");
			mTableValue = (String) data.get("tableValue");
			mScrollValue = (String) data.get("scrollValue");
		}
		System.out.println("JSONParser: Ready");
	}
	
	//*********Scroll to Element Function*********
	public static void scrollToElement(By mobileElement) {
		RemoteWebElement element = (RemoteWebElement)mobiledriver.findElement(mobileElement);
		String elementID = element.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", elementID);
		scrollObject.put("toVisible", "not an empty string");
		mobiledriver.executeScript("mobile:scroll", scrollObject);
	}
}