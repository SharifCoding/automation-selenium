package testGoogle;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.common.collect.ImmutableMap;
import mainGoogle.basePage;

class baseTest {
	
	public static WebDriver browser;
    public static String mPlatform = "";
  
    @Parameters ("JSONArray")
	@BeforeSuite
	public void setUp(String JSONArray) throws IOException, ParseException, InterruptedException {
		// get current date and time
		basePage.getDateAndTime();
		// add chosen JSON array to variable
		basePage.mJSONArray = JSONArray;
		// initiating read write JSON functionality
		basePage.readWriteJSON();
		System.out.println("Welcome to Selenium test automation");
		// value of the browserChoice parameter used to instantiate the corresponding driver class of Selenium WebDriver
		if (basePage.mBrowser.equalsIgnoreCase("Chrome")) {
		  	// setting the driver executable
			System.setProperty("webdriver.chrome.driver", basePage.myPath + "src/main/resources/chromedriver");   
		    // Initiating your Google Chrome web driver
		    browser = new ChromeDriver();
		    System.out.println("Browser Status: Initiating Google Chrome webdriver; chromedriver");       
		}
		else if (basePage.mBrowser.equalsIgnoreCase("Firefox")) {
			// setting the driver executable
			System.setProperty("webdriver.gecko.driver", basePage.myPath + "src/main/resources/geckodriver");
			// Initiating your Mozilla Firefox web driver
	  		browser = new FirefoxDriver();
	  		System.out.println("Browser Status: Initiating Mozilla Firefox webdriver; geckodriver");
		}
		else if (basePage.mBrowser.equalsIgnoreCase("Edge")) {
		  	// setting the driver executable
		    System.setProperty("webdriver.edge.driver", basePage.myPath + "src/main/resources/msedgedriver");
		    // Initiating your Microsoft Edge web driver
		    browser = new EdgeDriver();
	  		System.out.println("Browser Status: Initiating Edge webdriver; msedgedriver");
		}
		else if (basePage.mBrowser.equalsIgnoreCase("Safari")) {
			// Initiating your Apple Safari web driver
			browser = new SafariDriver();
			System.out.println("Browser Status: Initiating Safari webdriver; SafariDriver");
		}
		else {
			throw new IllegalArgumentException("Invalid browser value! Please input valid parameter in JSON array \"" + JSONArray + "\"");
		}
		// specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// modify browser size in Selenium so it matches a specific resolution
		browser.manage().window().setSize(new Dimension(1280, 800));
		System.out.println("Browser Status: Resolution 1280, 800");
		// initiating Allure Reporting - get browser name, version and OS details:-
	    Capabilities cap = ((RemoteWebDriver) browser).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String os = cap.getPlatform().toString();
	    mPlatform = os;
	    String browserVersion = cap.getVersion().toString();
			// Java library which allows to write environment.xml file into allure-results directory
			allureEnvironmentWriter(
	        ImmutableMap.<String, String>builder()
	        .put("Browser Name", browserName)
	        .put("Browser Version", browserVersion)
	        .put("Operating System", os)
	        .build(), System.getProperty("user.dir")
	        + "/allure-results/");
	}
  
	@AfterSuite
	public void closeUp() throws InterruptedException {
		try {
			// closing the browser
			browser.close();
			// closing the WebDriver
			browser.quit();
			System.out.println("Browser Status: Closing web driver");
		} catch (Exception e) { }		
		// launch CMD and run allure reporting
		try {
			// value of the platform parameter used to instantiate correct command program to generate allure report
			if (mPlatform.equals("WINDOWS")) {
				Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"allure serve allure-results\"");
				System.out.println("Allure Status: Do not close CMD while reporting is active");
			}
			else if (mPlatform.equals("MAC")) {
				Runtime.getRuntime().exec("open /bin/bash");
				System.out.println("Allure Status: Execute from terminal \"allure serve allure-results " + basePage.myPath + "\"");
			}
			else {
				throw new IllegalArgumentException("Please execute \"allure serve allure-results\" for report");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}