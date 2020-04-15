package mainPages;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
 
public class basePage {
       
	public static AndroidDriver<MobileElement> mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static String mAddSumOne = "";
	public static String mAddSumTwo = "";
	
    public static void waitForElement(By id, int time) {
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
    	Actions actions = new Actions(mobiledriver);
    	actions.moveToElement(mobiledriver.findElement(id)).perform();
    }
    
    public static void hoverOverElement(WebElement arrayID) throws InterruptedException {
    	Actions hover = new Actions(mobiledriver);
    	hover.moveToElement(arrayID).build().perform();
        Thread.sleep(500);
    }
    
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	// https://dzone.com/articles/selenium-data-parameterization-using-json
    	System.out.println("JSONParser: Initiating...");
      	// Read Data From JSON file
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "androidCalculator/src/test/resources/testData.json");
      	//Read JSON file
      	Object obj = jsonParser.parse(reader);
      	// JSONArray is used to parse JSON
      	JSONArray dataInfo = (JSONArray) obj;
      	//This prints the entire json file
      	System.out.println("JSONParser: entire json --> " + dataInfo);
      	// The .get method is used to access the values in the JSON by index
    	for(int i=0;i<dataInfo.size();i++) 
    	{
    		JSONObject dataBlock = (JSONObject) dataInfo.get(i);
    		//This prints every block - one json object
    		JSONObject data = (JSONObject) dataBlock.get("testData");
    		//This prints each data in the block
    		mAddSumOne = (String) data.get("addSumOne");
    		mAddSumOne = (String) data.get("addSumTwo");
    	}
    	System.out.println("JSONParser: Ready");
    }
}