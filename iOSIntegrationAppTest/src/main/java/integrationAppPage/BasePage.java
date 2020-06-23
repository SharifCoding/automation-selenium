package integrationAppPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {

	public static IOSDriver<IOSElement>mobiledriver;
    public static String mURL = "calshow://";
    public static String mTitle = "Appium/welcome";
    
	//*********Web Elements*********
	By CalendarButton = By.id("Calendars");
	
	//*********Functions*********
    public static void waitForElement(By id, int time) {
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
		JavascriptExecutor js = (JavascriptExecutor) mobiledriver;
		js.executeScript("arguments[0].scrollIntoView(true);", mobiledriver.findElement(id));
    }
}