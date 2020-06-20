package appiumiOSTest;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class baseTest
{
	protected IOSDriver<WebElement>mobiledriver;
		
	@BeforeSuite
	public void beforeSuite( ) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 6");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "12.4");
		caps.setCapability("browserName", "safari");
		caps.setCapability("noReset", "true");
		caps.setCapability("newCommandTimeout", 2000);
		// Instantiate Appium Driver
		try {
			mobiledriver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		mobiledriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// initiating Allure Reporting - get browser name, version and OS details:-
	    Capabilities cap = ((RemoteWebDriver) mobiledriver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String os = cap.getPlatform().toString();
	    String browserVersion = cap.getVersion().toString();
	    // Java library which allows to write environment.xml file into allure-results directory
	    allureEnvironmentWriter(
	        ImmutableMap.<String, String>builder()
	        .put("Browser Name", browserName)
	        .put("Browser Version", browserVersion)
	        .put("automationName", "XCUITest")
	        .put("Operating System", os)
	        .build(), System.getProperty("user.dir")
	        + "/allure-results/");
	}

	@AfterSuite
	public void afterSuite( ) {
		try {
			// clear cookies on the browser
			mobiledriver.manage().deleteAllCookies();
			// closing the browser
			mobiledriver.close();
			System.out.println("Test Status: Closing web driver");
		} catch (Exception e) { }	
			System.out.println("Allure Report: Execute \"allure serve allure-results\" from terminal");
	}
}
