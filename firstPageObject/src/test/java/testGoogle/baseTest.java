package testGoogle;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import mainGoogle.basePage;

class baseTest {
	
	public static WebDriver browser;
  
	@BeforeSuite
	public void setUp() throws IOException, ParseException, InterruptedException {
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
			throw new IllegalArgumentException("Invalid browser value! Please input valid parameters for 'jsonBrowserChoice'");
		}
		// specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 
		browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// modify browser size in Selenium so it matches a specific resolution
		browser.manage().window().setSize(new Dimension(1280, 800));
		System.out.println("Browser Status: Resolution 1280, 800");
	}
  
	@AfterSuite
	public void closeUp() {
		try {
			// closing the browser
			browser.close();
			// closing the WebDriver
			browser.quit();
			System.out.println("Browser Status: Closing web driver");
		} catch (Exception e) { }
	}
}