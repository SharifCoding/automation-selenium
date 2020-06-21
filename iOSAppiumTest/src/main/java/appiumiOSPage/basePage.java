package appiumiOSPage;

import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
public class basePage {

	public static IOSDriver<WebElement> mobiledriver;
    static List<String> array_list = new ArrayList<>();
    public static String mURL = "http://appium.io/";
    public static String mTitle = "Appium: Mobile App Automation Made Awesome.";
    
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
	By IntroducingAppium = By.id("introducing-appium");
	By MarketingByline = By.className("marketing-byline");
	By WatchVideosButton = By.xpath("//*[contains(text(), 'Watch the Videos')]");
	By ShowDemoVideo = By.id("show-demo-video");
	By DemoVideoElements = By.xpath("//*[@id='show-demo-video']//iframe");
	By EasySetupProcess = By.xpath("//*[@data-localize='easy-setup']");
	
	//*********Functions*********
    public static void waitForElement(By id, int time) {
    	new WebDriverWait(mobiledriver, 30).until(ExpectedConditions.elementToBeClickable(id));
    }
    
    public static void scrollToElement(By id) {
		JavascriptExecutor js = (JavascriptExecutor) mobiledriver;
		js.executeScript("arguments[0].scrollIntoView(true);", mobiledriver.findElement(id));
    }
    
    public static void checkListAttribute(By id, String providedAttribute) {
        List<WebElement> myList=mobiledriver.findElements(id);
        List<String> all_elements_attribute=new ArrayList<>();
        for(int i=0; i<myList.size(); i++){
        	all_elements_attribute.add(myList.get(i).getAttribute(providedAttribute));
            Assert.assertNotNull(myList.get(i).getAttribute(providedAttribute));
        }
        array_list = all_elements_attribute;
    }
}