package integrationAppPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
 
public class BasePage {

	public static IOSDriver<IOSElement>mobiledriver;
    public static String mURL = "calshow://";
    public static String mTitle = "Appium/welcome";
    
	//*********Web Elements*********
	By OtherMainView = By.xpath("//XCUIElementTypeOther[@name=\"MainView\"]");
	By NavigationBarView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"View\"]");
	By ButtonAlerts = By.xpath("//XCUIElementTypeButton[@name=\"Alerts\"]");
	By ButtonDeadlock = By.xpath("//XCUIElementTypeButton[@name=\"Deadlock app\"]");
	By ButtonAttributes = By.xpath("//XCUIElementTypeButton[@name=\"Attributes\"]");
	By ButtonScrolling = By.xpath("//XCUIElementTypeButton[@name=\"Scrolling\"]");
	By TextPortrait = By.xpath("//XCUIElementTypeStaticText[@name=\"Portrait\"]");
	By TextLandscape = By.xpath("//XCUIElementTypeStaticText[@name=\"LandscapeRight\"]");
	By NavigationBarUIView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"UIView\"]");
	By ButtonBack = By.xpath("//XCUIElementTypeButton[@name=\"Back\"]");
	By ButtonTableView = By.xpath("//XCUIElementTypeButton[@name=\"TableView\"]");
	By ButtonScrollView = By.xpath("//XCUIElementTypeButton[@name=\"ScrollView\"]");
	By NavigationBarUITableView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"UITableView\"]");
	By UITableViewValue = By.xpath("//XCUIElementTypeStaticText[@name=\"49\"]");
	By NavigationBarFBScrollView = By.xpath("//XCUIElementTypeNavigationBar[@name=\"FBScrollView\"]");
	
	//*********Functions*********
	public static void scrollToElement() {
		// https://developers.perfectomobile.com/pages/viewpage.action?pageId=25199704
        RemoteWebElement element = (RemoteWebElement)mobiledriver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"49\"]"));
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
        scrollObject.put("toVisible", "not an empty string");
        mobiledriver.executeScript("mobile:scroll", scrollObject);
	}
}