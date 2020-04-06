package mainPages;
 
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
public class basePage {
       
    public static WebDriver browser;
    public static String mJSONArray = "";
    public static String mBrowser = "";
    public static String mURL = "";
    public static String mDate = "";
    static List<String> array_list = new ArrayList<>();
	public static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/githubPageTest/";
 
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	// https://dzone.com/articles/selenium-data-parameterization-using-json
    	System.out.println("JSONParser: Initiating...");
      	// Read Data From JSON file
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "src/test/resources/testData.json");
      	//Read JSON file
      	Object obj = jsonParser.parse(reader);
      	// JSONArray is used to parse JSON
      	JSONArray patronInfo = (JSONArray) obj;
      	//This prints the entire json file
      	System.out.println("JSONParser: Entire JSON --> " + patronInfo);
      	// The .get method is used to access the values in the JSON by index
    	for(int i=0;i<patronInfo.size();i++) 
    	{
    		JSONObject patrons = (JSONObject) patronInfo.get(i);
    		//This prints every block - one json object
    		JSONObject patron = (JSONObject) patrons.get(mJSONArray);
    		//This prints each data in the block
    		mBrowser = (String) patron.get("jsonBrowserChoice");
    		mURL = (String) patron.get("jsonURL");
    		mDate = (String) patron.get("jsonDate");
    	}
    	System.out.println("JSONParser: Ready");
    }
      
    public static void getDateAndTime(String mDateInput) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("getDateAndTime: " + dateFormat.format(new Date()));
		if (mDateInput.equalsIgnoreCase("dd")) {
			SimpleDateFormat dateFormatDay = new SimpleDateFormat("dd");
			mDate = dateFormatDay.format(new Date());
			System.out.println("getDateAndTime: " + mDate);
		}
		else if (mDateInput.equalsIgnoreCase("MM")) {
			SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MM");
			mDate = dateFormatMonth.format(new Date());
			System.out.println("getDateAndTime: " + mDate);
		}
		else if (mDateInput.equalsIgnoreCase("yyyy")) {
			SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy");
			mDate = dateFormatYear.format(new Date());
			System.out.println("getDateAndTime: " + mDate);
		}
		else {
			throw new IllegalArgumentException("getDateAndTime: invalid value");
		}
    }
      
    public static void waitForElement(By id, int time) {
    	// Wait so that the app loads completely BEFORE starting with element identification
    	new WebDriverWait(browser, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
    	// use the org.openqa.selenium.interactions.Actions class to move to an element.
    	Actions actions = new Actions(browser);
    	actions.moveToElement(browser.findElement(id)).perform();
    }
    
    public static void hoverOverElement(WebElement arrayID) throws InterruptedException {
    	// use the org.openqa.selenium.interactions.Actions class to move to an element.
    	Actions hover = new Actions(browser);
    	hover.moveToElement(arrayID).build().perform();
        Thread.sleep(500);
    }
    
    public static void checkListAttribute(By id, String providedAttribute) {
        // To catch all web elements into list
        List<WebElement> myList=browser.findElements(id);
        // myList contains all the web elements
        // To get all elements href into array list
        List<String> all_elements_attribute=new ArrayList<>();
        for(int i=0; i<myList.size(); i++){
            // Loading href of each element in to array all_elements_href
        	all_elements_attribute.add(myList.get(i).getAttribute(providedAttribute));
            // Asserts that an object isn't null. If it is, an AssertionError is thrown.
            Assert.assertNotNull(myList.get(i).getAttribute(providedAttribute));
        }
        array_list = all_elements_attribute;
    }
}