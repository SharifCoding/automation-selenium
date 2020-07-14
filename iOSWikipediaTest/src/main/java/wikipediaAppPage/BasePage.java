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
	public static String mStringValue = "";
    
	//*********Main Mobile Elements*********
	By Toolbar = By.xpath("//XCUIElementTypeToolbar[@name=\"Toolbar\"]/XCUIElementTypeOther/XCUIElementTypeOther");
	By SearchFieldSearchWikipedia = By.xpath("//XCUIElementTypeSearchField[@name=\"Search Wikipedia\"]");
	
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
			mStringValue = (String) data.get("stringValue");
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