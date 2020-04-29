package mainPages;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
 
public class basePage {
	
	public static AndroidDriver<MobileElement> mobiledriver;
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";
	Integer mDigitNumber = 0;
	public static String mSelectSinCosTan;
	public static Long mDegreesValue;
	
	//*********Container Mobile Elements*********
	By CalculatorToolbar = By.id("com.google.android.calculator:id/toolbar");
	By CalculatorDisplay = By.id("com.google.android.calculator:id/display");
	By CalculatorPadBasic = By.id("com.google.android.calculator:id/pad_basic");
	By CalculatorPadNumeric = By.id("com.google.android.calculator:id/pad_numeric");
	By CalculatorPadOperator = By.id("com.google.android.calculator:id/pad_operator");
	By CalculatorPadAdvanced = By.id("com.google.android.calculator:id/pad_advanced");

	//*********Display Mobile Elements*********
	By DisplayFormula = By.id("com.google.android.calculator:id/formula");
	By DisplayResultFinal = By.id("com.google.android.calculator:id/result_final");
	By DisplaySymbolic = By.id("com.google.android.calculator:id/symbolic");
	By DisplayDegreeRadian = By.id("com.google.android.calculator:id/mode");
	
	//*********Pad Operator Mobile Elements*********
	By DeleteButton = By.id("com.google.android.calculator:id/del");
	By ClearButton = By.id("com.google.android.calculator:id/clr");
	By OperatorPlusButton = By.id("com.google.android.calculator:id/op_add");
	By OperatorMinusButton = By.id("com.google.android.calculator:id/op_sub");
	By OperatorMultiplyButton = By.id("com.google.android.calculator:id/op_mul");
	By OperatorDivideButton = By.id("com.google.android.calculator:id/op_div");
	By DecimalPointButton = By.id("com.google.android.calculator:id/dec_point");
	By EqualButton = By.id("com.google.android.calculator:id/eq");
	By DigitButtons = By.id("com.google.android.calculator:id/digit_" + Integer.toString(mDigitNumber));
	
	//*********More Options Elements*********
	By MoreOptionsButton = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
	By OptionHistory = By.xpath("//android.widget.TextView[@text=\"History\"]");
	By OptionChooseTheme = By.xpath("//android.widget.TextView[@text=\"Choose theme\"]");
	By OptionSendFeedback = By.xpath("//android.widget.TextView[@text=\"Send feedback\"]");
	By OptionHelp = By.xpath("//android.widget.TextView[@text=\"Help\"]");
	
	//*********Non-Inverse Functions Elements*********
	By CloseArrowButton = By.id("com.google.android.calculator:id/arrow");
	By InverseButton = By.id("com.google.android.calculator:id/toggle_inv");
	By DegreeRadiansButton = By.id("com.google.android.calculator:id/toggle_mode");
	By PercentButton = By.id("com.google.android.calculator:id/op_pct");
	By SineButton = By.id("com.google.android.calculator:id/fun_sin");
	By CosineButton = By.id("com.google.android.calculator:id/fun_cos");
	By TangentButton = By.id("com.google.android.calculator:id/fun_tan");
	By NaturalLogarithmButton = By.id("com.google.android.calculator:id/fun_ln");
	By LogarithmButton = By.id("com.google.android.calculator:id/fun_log");
	By SquareRootButton = By.id("com.google.android.calculator:id/op_sqrt");
	By PiButton = By.id("com.google.android.calculator:id/const_pi");
	By EulersNumberButton = By.id("com.google.android.calculator:id/const_e");
	By LeftParenthesisButton = By.id("com.google.android.calculator:id/lparen");
	By RightParenthesisButton = By.id("com.google.android.calculator:id/rparen");
	By FactorialButton = By.id("com.google.android.calculator:id/op_fact");

	//*********Inverse Functions Elements*********
	By InverseSineButton = By.id("com.google.android.calculator:id/fun_arcsin");
	By InverseCosineButton = By.id("com.google.android.calculator:id/fun_arccos");
	By InverseTangentButton = By.id("com.google.android.calculator:id/fun_arctan");
	By ExponentialFunctionButton = By.id("com.google.android.calculator:id/fun_exp");
	By TenPowerButton = By.id("com.google.android.calculator:id/fun_10pow");
	By SquaredButton = By.id("com.google.android.calculator:id/op_sqr");
	
    public static void coordinatePadAdvanced() {
        Dimension size = mobiledriver.manage().window().getSize();
        int xOffset_pad_advanced = (int) (size.getWidth() * 0.95);
        int yOffset_pad_advanced = (int) (size.getHeight() * 0.65);
        new TouchAction<>(mobiledriver).tap(PointOption.point(xOffset_pad_advanced, yOffset_pad_advanced)).perform();
        System.out.println("Test Status: xOffset: '" + xOffset_pad_advanced + "' yOffset: '" + yOffset_pad_advanced +"'");
	}
    
    public static void isElementNotPresent(By id) {
    	new WebDriverWait(mobiledriver, 5).until(ExpectedConditions.invisibilityOfElementLocated(id));
    }
    	
	public static int randomInteger(int min, int max) {
    	return min + (int)(Math.random() * ((max - min) + 1));
	}
    
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	System.out.println("JSONParser: Initiating...");
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "androidCalculatorExt/src/test/resources/testData.json");
      	Object obj = jsonParser.parse(reader);
      	JSONArray dataInfo = (JSONArray) obj;
      	System.out.println("JSONParser: entire json --> " + dataInfo);
    	for(int i=0 ; i < dataInfo.size(); i++) 
    	{
    		JSONObject dataBlock = (JSONObject) dataInfo.get(i);
    		JSONObject data = (JSONObject) dataBlock.get("testData");
    		mSelectSinCosTan = (String) data.get("selectSinCosTan");
    		mDegreesValue = (Long) data.get("degreesValue");
    	}
    	System.out.println("JSONParser: Ready");
    }
}