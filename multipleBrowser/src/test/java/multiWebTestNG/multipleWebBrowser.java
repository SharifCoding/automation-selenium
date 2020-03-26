package multiWebTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class multipleWebBrowser {

	private WebDriver driver;
	private String myPath = "/Users/macbook/Documents/GitHub/learnSelenium/";

    @BeforeClass
    @Parameters ("mBrowser")
    public void beforeClass(String mBrowser) {
    	System.out.println("Welcome to selenium test automation");
		// value of the browserChoice parameter used to instantiate the corresponding driver class of Selenium WebDriver
		if (mBrowser.equalsIgnoreCase("Chrome")) {
		  	// setting the driver executable
		    System.setProperty("webdriver.chrome.driver", myPath + "multipleBrowser/src/main/resources/chromedriver");   
		    // Initiating your Google Chrome web driver
		    driver = new ChromeDriver();
		    System.out.println("Browser Status: Initiating Google Chrome webdriver; chromedriver");       
		}
		else if (mBrowser.equalsIgnoreCase("Firefox")) {
			// setting the driver executable
			System.setProperty("webdriver.gecko.driver", myPath + "multipleBrowser/src/main/resources/geckodriver");
			// Initiating your Mozilla Firefox web driver
			driver = new FirefoxDriver();
			System.out.println("Browser Status: Initiating Mozilla Firefox webdriver; geckodriver");
		}
		else if (mBrowser.equalsIgnoreCase("Edge")) {
		  	// setting the driver executable
		    System.setProperty("webdriver.edge.driver", myPath + "multipleBrowser/src/main/resources/msedgedriver");
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
	    driver.get("http://www.google.com");
	    // strings are constant; their values cannot be changed after they are created
	    String search_text = "Google Search";
	    // find the WebElement using the given method which is affected by the 'implicit wait' times in force
	    WebElement search_button = driver.findElement(By.name("btnK"));
	    // get the value of the given attribute of the element
	    String text = search_button.getAttribute("value");
	    // asserts that two Strings are equal, otherwise an AssertionError is thrown with the given message
	    Assert.assertEquals(text, search_text, "Text not found!");
	}
}
