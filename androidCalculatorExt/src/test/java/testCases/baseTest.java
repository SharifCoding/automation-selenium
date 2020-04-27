package testCases;

import com.google.common.collect.ImmutableMap;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import mainPages.basePage;

public class baseTest
{
	public static AndroidDriver<MobileElement> mobiledriver;

	@BeforeSuite
	public void setUp( ) throws InterruptedException, IOException, ParseException {
		System.out.println("Welcome to Appium mobile automation");
		basePage.readWriteJSON();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Nexus_5_API_29");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("appPackage", "com.google.android.calculator");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", "true");
		caps.setCapability("newCommandTimeout", 2000);
		try {
			mobiledriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			String appId="com.google.android.calculator";
			System.out.println("isAppInstalled: " + mobiledriver.isAppInstalled(appId));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		mobiledriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Capabilities cap = ((RemoteWebDriver) mobiledriver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    String os = cap.getPlatform().toString();
	    String browserVersion = cap.getVersion().toString();
		allureEnvironmentWriter(
	        ImmutableMap.<String, String>builder()
	        .put("Browser Name", browserName)
	        .put("Browser Version", browserVersion)
	        .put("Operating System", os)
	        .build(), System.getProperty("user.dir")
	        + "/allure-results/");
	}

	@AfterSuite
	public void tearDown( ) {
		try {
			mobiledriver.closeApp();
			mobiledriver.quit();
			System.out.println("Test Status: closing web driver");
		} catch (Exception e) { }	
		System.out.println("Allure Report: execute \"allure serve allure-results\" from terminal");
	}
}
