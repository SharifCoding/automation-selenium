package wikipediaAppPage;

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
	public static String mSearchString = "";
    	
	//********* Explore Mobile Elements *********
	By ButtonExplore = By.xpath("//XCUIElementTypeButton[@name=\"Explore\"]");
	By ButtonExploreActive = By.xpath("//XCUIElementTypeButton[@name=\"Explore\"][@value=\"1\"]");
	By Toolbar = By.xpath("//XCUIElementTypeToolbar[@name=\"Toolbar\"]/XCUIElementTypeOther/XCUIElementTypeOther");
	By ButtonWikipedia = By.xpath("//XCUIElementTypeButton[@name=\"wikipedia\"]");
	By ButtonSettings = By.xpath("//XCUIElementTypeButton[@name=\"Settings\"]");
	By TextSettings = By.xpath("//XCUIElementTypeStaticText[@name=\"Settings\"]");
	By ButtonClose = By.xpath("//XCUIElementTypeButton[@name=\"Close\"]");
	By TextAboutTheApp = By.xpath("//XCUIElementTypeStaticText[@name=\"About the app\"]");
	By ButtonAbout = By.xpath("//XCUIElementTypeButton[@name=\"About\"]");
	By SearchField = By.xpath("//XCUIElementTypeSearchField[@name=\"Search Wikipedia\"]");
	By SearchReturn = By.xpath("//XCUIElementTypeLink[@name=\"" + mSearchString + "\"]");
	By SearchLoaded = By.xpath("//XCUIElementTypeStaticText[@name=\"" + mSearchString + "\"][1]");
	
	//********* Places Mobile Elements *********
	By ButtonPlaces = By.xpath("//XCUIElementTypeButton[@name=\"Places\"]");
	By TextPlaces = By.xpath("//XCUIElementTypeStaticText[@name=\"Places\"]");
	By ButtonFilter = By.xpath("//XCUIElementTypeButton[@name=\"Filter\"]");
	By SearchPlaces = By.xpath("//XCUIElementTypeSearchField[@name=\"Search Places\"]");
	By ShowAsMap = By.xpath("//XCUIElementTypeButton[@name=\"Show as map\"]");
	By ShowAsList = By.xpath("//XCUIElementTypeButton[@name=\"Show as list\"]");
	
	//********* Saved Mobile Elements *********
	By ButtonSaved = By.xpath("//XCUIElementTypeButton[@name=\"Saved\"]");
	By TextSaved = By.xpath("//XCUIElementTypeStaticText[@name=\"Saved\"]");
	By AllArticles = By.xpath("//XCUIElementTypeButton[@name=\"All articles\"]");
	By ReadingLists = By.xpath("//XCUIElementTypeButton[@name=\"Reading lists\"]");
	
	//********* History Mobile Elements *********
	By ButtonHistory = By.xpath("//XCUIElementTypeButton[@name=\"History\"]");
	By TextHistory = By.xpath("//XCUIElementTypeStaticText[@name=\"History\"]");
	By ButtonClear = By.xpath("///XCUIElementTypeButton[@name=\"Clear\"]");
	
	//********* Search Mobile Elements *********
	By ButtonSearch = By.xpath("//XCUIElementTypeButton[@name=\"Search\"]");
	By TextSearch = By.xpath("//XCUIElementTypeStaticText[@name=\"Search\"]");
	By RecentlySearched = By.xpath("//XCUIElementTypeStaticText[@name=\"Recently searched\"]");
	
	//*********Read JSON Function*********
	public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
		System.out.println("JSONParser: Initiating...");
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(myPath + "iOSWikipediaTest/src/test/resources/testData.json");
		Object obj = jsonParser.parse(reader);
		JSONArray dataInfo = (JSONArray) obj;
		System.out.println("JSONParser: entire json --> " + dataInfo);
		for(int i=0; i < dataInfo.size(); i++) 
		{
			JSONObject dataBlock = (JSONObject) dataInfo.get(i);
			JSONObject data = (JSONObject) dataBlock.get("testData");
			mSearchString = (String) data.get("searchString");
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