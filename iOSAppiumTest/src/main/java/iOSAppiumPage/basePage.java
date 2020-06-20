package iOSAppiumPage;

import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
public class basePage {

	public static IOSDriver<WebElement> mobiledriver;
    static List<String> array_list = new ArrayList<>();
    public static String mURL = "http://appium.io/";
    
	//*********Web Elements*********
	By DownloadButton = By.id("downloadLink");
	By AppiumNavbar = By.className("navbar-brand");
	By HamburgerIcon = By.className("navbar-toggle");
	By HamburgerMenu = By.id("bs-example-navbar-collapse-1");
	By DropdownHome = By.xpath("//a[@data-localize=\"home-nav-link\"]");
	By DropdownIntroduction = By.xpath("//a[@data-localize=\"intro-nav-link\"]");
	By DropdownGetStarted = By.xpath("//a[@data-localize=\"getting-started-nav-link\"]");
	By DropdownHistory = By.xpath("//a[@data-localize=\"history-nav-link\"]");
	By DropdownGetInvolved = By.xpath("//a[@data-localize=\"get-involved-nav-link\"]");
	By DropdownDocumentation = By.xpath("//a[@data-localize=\"docs-nav-link\"]");
	By DropdownBooksResources = By.xpath("//a[@data-localize=\"docs-nav-resources\"]");
	
	//*********Functions*********
    public static void waitForElement(By id, int time) {
    	// Wait so that the app loads completely BEFORE starting with element identification
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
    	// use the org.openqa.selenium.interactions.Actions class to move to an element.
    	Actions actions = new Actions(mobiledriver);
    	actions.moveToElement(mobiledriver.findElement(id)).perform();
    }
    
    public static void checkListAttribute(By id, String providedAttribute) {
        // To catch all web elements into list
        List<WebElement> myList=mobiledriver.findElements(id);
        // myList contains all the web elements
        // To get all elements href into array list
        List<String> all_elements_attribute=new ArrayList<>();
        for(int i=0; i<myList.size(); i++){
            // Loading href of each element in to array all_elements_href
        	all_elements_attribute.add(myList.get(i).getAttribute(providedAttribute));
            // Asserts that an object isn't null. If it is, an AssertionError is thrown.
            Assert.assertNotNull(myList.get(i).getAttribute(providedAttribute));
        }
        array_list = all_elements_attribute;
    }
}