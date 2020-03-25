package firstTestNG;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;  
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class firstTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
	    // initiating Safari web driver
        driver = new SafariDriver();
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