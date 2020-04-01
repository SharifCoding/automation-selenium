package mainPages;
 
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class basePage {
       
    public static WebDriver browser;
    public static String mJSONArray = "";
    public static String mBrowser = "";
    public static String mURL = "";
    public static String mSearchString = "";
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
    		mSearchString = (String) patron.get("jsonSearchString");
    	}
    	System.out.println("JSONParser: Ready");
    }
      
    public static void getDateAndTime() {
      	Timestamp stamp = new Timestamp(System.currentTimeMillis());
    	System.out.println(stamp);
    }
      
    public static void waitForElement(By id, int time) {
    	// Wait so that the app loads completely BEFORE starting with element identification
    	new WebDriverWait(browser, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
}