package testCases;

import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;

public class baseTest
{
	public static AndroidDriver<WebElement> mobiledriver;

	@BeforeTest
	public void beforeTest( ) throws MalformedURLException {
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_5_API_29");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("noReset", "true");
		caps.setCapability("newCommandTimeout", 2000);
		// Instantiate Appium Driver
		try {
			mobiledriver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
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
	        .put("Operating System", os)
	        .build(), System.getProperty("user.dir")
	        + "/allure-results/");
	}

	@AfterTest
	public void afterTest( ) {
		try {
			// closing the browser
			mobiledriver.close();
			// closing the WebDriver
			mobiledriver.quit();
			System.out.println("Test Status: Closing web driver");
		} catch (Exception e) { }	
		System.out.println("Allure Report: Execute \"allure serve allure-results\" from terminal");
	}
}
