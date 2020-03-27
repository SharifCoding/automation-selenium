package simpleJSON;

import java.util.concurrent.TimeUnit;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class simpleJSONParameters {

	private WebDriver driver;
    public static String mBrowser = "";
    public static String mURL = "";
    public static String mSearchString = "";
	private static String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";

    @BeforeClass
    public void beforeClass() throws InterruptedException, IOException, ParseException {
    	System.out.println("Welcome to Selenium test automation");
    	// call the simple JSON functionality
    	readWriteJSON();
		// value of the browserChoice parameter used to instantiate the corresponding driver class of Selenium WebDriver
		if (mBrowser.equalsIgnoreCase("Chrome")) {
			// setting the driver executable
			System.setProperty("webdriver.chrome.driver", myPath + "simpleJSON/src/main/resources/chromedriver");   
			// Initiating your Google Chrome web driver
			driver = new ChromeDriver();
			System.out.println("Browser Status: Initiating Google Chrome webdriver; chromedriver");       
		}
		else if (mBrowser.equalsIgnoreCase("Firefox")) {
			// setting the driver executable
			System.setProperty("webdriver.gecko.driver", myPath + "simpleJSON/src/main/resources/geckodriver");
			// Initiating your Mozilla Firefox web driver
			driver = new FirefoxDriver();
			System.out.println("Browser Status: Initiating Mozilla Firefox webdriver; geckodriver");
		}
		else if (mBrowser.equalsIgnoreCase("Edge")) {
			// setting the driver executable
			System.setProperty("webdriver.edge.driver", myPath + "simpleJSON/src/main/resources/msedgedriver");
			// Initiating your Microsoft Edge web driver
			driver = new EdgeDriver();
			System.out.println("Browser Status: Initiating Edge webdriver; msedgedriver");
		}
		else if (mBrowser.equalsIgnoreCase("Safari")) {
			// Initiating your Apple Safari web driver
			driver = new SafariDriver();
			System.out.println("Browser Status: Initiating Safari webdriver; SafariDriver");
		}
		else {
			throw new IllegalArgumentException("Invalid browser value! Please input valid parameters for 'jsonBrowserChoice'");
		}    	    	
		// specifies the amount of time the driver should wait when searching for an element if it is not immediately present
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maximise window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
    	// closing the browser
        driver.close();
    }

	@Test
	public void verifySearchButton() {
		// open browser with desired URL
	    driver.get(mURL);
	    // strings are constant; their values cannot be changed after they are created
	    String search_text = "Google Search";
	    // find the WebElement using the given method which is affected by the 'implicit wait' times in force
	    WebElement search_button = driver.findElement(By.name("btnK"));
	    // get the value of the given attribute of the element
	    String text = search_button.getAttribute("value");
	    // asserts that two Strings are equal, otherwise an AssertionError is thrown with the given message
	    Assert.assertEquals(text, search_text, "Text not found!");
		System.out.println("Test Status: Search Button is present");
	}
	
	@Test
	public void verifySearchInputField() throws InterruptedException {
	  	// locating an element by CSS ID
	  	WebElement search = driver.findElement(By.name("q"));
	  	// assertTrue(boolean condition) Asserts that a condition is true
	  	Assert.assertTrue(search.isDisplayed());
		System.out.println("Test Status: Search Input Field is present");
		// keysToSend character sequence to send to the element
		search.sendKeys(mSearchString);
		search.sendKeys(Keys.ENTER);
		// current executing thread sleep for specified milliseconds
		Thread.sleep(2000);
		System.out.println("Test Status: Inputted string executed");
		// checking that an element is present on the DOM of a page
    	new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats"))); 
	  }
	
    public static void readWriteJSON() throws InterruptedException, IOException, ParseException {
    	// https://dzone.com/articles/selenium-data-parameterization-using-json
    	System.out.println("JSONParser: Initiating...");
      	// Read Data From JSON file
      	JSONParser jsonParser = new JSONParser();
      	FileReader reader = new FileReader(myPath + "simpleJSON/src/test/resources/testData.json");
      	//Read JSON file
      	Object obj = jsonParser.parse(reader);
      	// JSONArray is used to parse JSON
      	JSONArray patronInfo = (JSONArray) obj;
      	//This prints the entire json file
      	System.out.println("JSONParser: entire json --> " + patronInfo);
      	// The .get method is used to access the values in the JSON by index
    	for(int i=0;i<patronInfo.size();i++) 
    	{
    		JSONObject patrons = (JSONObject) patronInfo.get(i);
    		//This prints every block - one json object
    		JSONObject patron = (JSONObject) patrons.get("testData");
    		//This prints each data in the block
    		mBrowser = (String) patron.get("jsonBrowserChoice");
    		mURL = (String) patron.get("jsonURL");
    		mSearchString = (String) patron.get("jsonSearchString");
    	}
    	System.out.println("JSONParser: Ready");
    }
}
