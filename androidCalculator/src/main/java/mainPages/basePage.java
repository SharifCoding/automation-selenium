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
	
	//*********Container Mobile Elements*********
	By CalculatorToolbar = By.id("com.google.android.calculator:id/toolbar");
	By CalculatorDisplay = By.id("com.google.android.calculator:id/display");
	By CalculatorPadNumeric = By.id("com.google.android.calculator:id/pad_numeric");
	By CalculatorPadOperator = By.id("com.google.android.calculator:id/pad_operator");
	
	//*********Operator Mobile Elements*********
	By OperatorPlusButton = By.id("com.google.android.calculator:id/op_add");
	By OperatorMinusButton = By.id("com.google.android.calculator:id/op_sub");
	By OperatorMultiplyButton = By.id("com.google.android.calculator:id/op_mul");
	By OperatorDivideButton = By.id("com.google.android.calculator:id/op_div");
	By DecimalPointButton = By.id("com.google.android.calculator:id/dec_point");
	By EqualButton = By.id("com.google.android.calculator:id/eq");
	By DisplayFormula = By.id("com.google.android.calculator:id/formula");
	By DisplayResultFinal = By.id("com.google.android.calculator:id/result_final");
       
	public static AndroidDriver<MobileElement> mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static Long mAddSumOne;
	public static Long mAddSumTwo;
	public static Long mAddEqual;
	
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
    		mAddSumOne = (Long) data.get("addSumOne");
    		mAddSumTwo = (Long) data.get("addSumTwo");
    		mAddEqual = mAddSumOne + mAddSumTwo;
    		//mAddEqual = (String) data.get("addEqual");
    	}
    	System.out.println("JSONParser: Ready");
    }
}