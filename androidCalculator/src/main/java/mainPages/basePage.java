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
	
	//*********Display Mobile Elements*********
	By DisplayFormula = By.id("com.google.android.calculator:id/formula");
	By DisplayResultFinal = By.id("com.google.android.calculator:id/result_final");
	By DisplaySymbolic = By.id("com.google.android.calculator:id/symbolic");
	
	//*********Pad Operator Mobile Elements*********
	By DeleteButton = By.id("com.google.android.calculator:id/del");
	By ClearButton = By.id("com.google.android.calculator:id/clr");
	By OperatorPlusButton = By.id("com.google.android.calculator:id/op_add");
	By OperatorMinusButton = By.id("com.google.android.calculator:id/op_sub");
	By OperatorMultiplyButton = By.id("com.google.android.calculator:id/op_mul");
	By OperatorDivideButton = By.id("com.google.android.calculator:id/op_div");
	By DecimalPointButton = By.id("com.google.android.calculator:id/dec_point");
	By EqualButton = By.id("com.google.android.calculator:id/eq");
       
	public static AndroidDriver<MobileElement> mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	public static Long mAddSumOne;
	public static Long mAddSumTwo;
	public static Long mSubtractSumOne;
	public static Long mSubtractSumTwo;
	public static Long mMultiplySumOne;
	public static Long mMultiplySumTwo;
	public static Long mDivideSumOne;
	public static Long mDivideSumTwo;
	Integer mAddRandomOne = randomInteger(0, 9);
	Integer mAddRandomTwo = randomInteger(0, 9);
	Integer mSubtractRandomOne = randomInteger(5, 9);
	Integer mSubtractRandomTwo = randomInteger(0, 5);
	Integer mMultiplyRandomOne = randomInteger(0, 9);
	Integer mMultiplyRandomTwo = randomInteger(0, 9);
	Integer mDivideRandomOne = randomInteger(0, 5);
	Integer mDivideRandomTwo = randomInteger(5, 9);
	
    public static void waitForElement(By id, int time) {
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void hoverOverElement(WebElement arrayID) throws InterruptedException {
    	Actions hover = new Actions(mobiledriver);
    	hover.moveToElement(arrayID).build().perform();
        Thread.sleep(500);
    }
    
    public static int randomInteger(int min, int max) {
    	return min + (int)(Math.random() * ((max - min) + 1));
	}
    
    public static long[] floorAndRemainder(long a, long b) {
    	long floor = a / b;
    	if ((a < 0 ^ b < 0) && a % b != 0) {
    		floor--;
    	}
    	long remainder = Math.abs(a - floor * b);
    	return new long[] {
    			floor, remainder
    	};
	}
    
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	System.out.println("JSONParser: Initiating...");
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "androidCalculator/src/test/resources/testData.json");
      	Object obj = jsonParser.parse(reader);
      	JSONArray dataInfo = (JSONArray) obj;
      	System.out.println("JSONParser: entire json --> " + dataInfo);
    	for(int i=0;i<dataInfo.size();i++) 
    	{
    		JSONObject dataBlock = (JSONObject) dataInfo.get(i);
    		JSONObject data = (JSONObject) dataBlock.get("testData");
    		mAddSumOne = (Long) data.get("addSumOne");
    		mAddSumTwo = (Long) data.get("addSumTwo");
    		mSubtractSumOne = (Long) data.get("subtractSumOne");
    		mSubtractSumTwo = (Long) data.get("subtractSumTwo");
    		mMultiplySumOne = (Long) data.get("multiplySumOne");
    		mMultiplySumTwo = (Long) data.get("multiplySumTwo");
    		mDivideSumOne = (Long) data.get("divideSumOne");
    		mDivideSumTwo = (Long) data.get("divideSumTwo");
    	}
    	System.out.println("JSONParser: Ready");
    }
}