package wikipediaAppTest;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import wikipediaAppPage.BasePage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest
{
	protected IOSDriver<IOSElement>mobiledriver;
		
	@BeforeSuite
	public void beforeSuite( ) throws InterruptedException, IOException, ParseException {
		System.out.println("Welcome to Appium mobile automation");
		BasePage.readWriteJSON();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 6");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "12.4");
		caps.setCapability("bundleId", "org.wikimedia.wikipedia"); 
		caps.setCapability("orientation", "PORTRAIT");
		caps.setCapability("automationName", "XCUITest");
		caps.setCapability("noReset", true);
		caps.setCapability("newCommandTimeout", 2000);
		try {
			mobiledriver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		mobiledriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    Capabilities cap = ((RemoteWebDriver) mobiledriver).getCapabilities();
	    String os = cap.getPlatform().toString();
	    allureEnvironmentWriter(
	        ImmutableMap.<String, String>builder()
	        .put("App Name", "Wikipedia iOS App")
	        .put("automationName", "XCUITest")
	        .put("Operating System", os)
	        .build(), System.getProperty("user.dir")
	        + "/allure-results/");
	}

	@AfterSuite
	public void afterSuite( ) {
		mobiledriver.closeApp();
		try {
			mobiledriver.close();
			System.out.println("Test Status: Closing iOS driver");
		} catch (Exception e) { }	
			System.out.println("Allure Report: Execute \"allure serve allure-results\" from terminal");
	}
}
