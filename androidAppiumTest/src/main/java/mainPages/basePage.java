package mainPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
 
public class basePage {
       
	public static AndroidDriver<WebElement> mobiledriver;
    public static String mURL = "http://appium.io/";
	
    public static void waitForElement(By id, int time) {
    	// Wait so that the app loads completely BEFORE starting with element identification
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
    	// use the org.openqa.selenium.interactions.Actions class to move to an element.
    	Actions actions = new Actions(mobiledriver);
    	actions.moveToElement(mobiledriver.findElement(id)).perform();
    }
    
    public static void hoverOverElement(WebElement arrayID) throws InterruptedException {
    	// use the org.openqa.selenium.interactions.Actions class to move to an element.
    	Actions hover = new Actions(mobiledriver);
    	hover.moveToElement(arrayID).build().perform();
        Thread.sleep(500);
    }
}