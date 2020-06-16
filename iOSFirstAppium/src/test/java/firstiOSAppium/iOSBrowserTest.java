package firstiOSAppium;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;

public class iOSBrowserTest
{
	private IOSDriver<WebElement> mobiledriver;
		
	@BeforeTest
	public void beforeTest( ) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "iPhone 6");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "12.4");
		caps.setCapability("browserName", "safari");
		caps.setCapability("noReset", "true");
		caps.setCapability("newCommandTimeout", 2000);
		mobiledriver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		mobiledriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest( ) {
		mobiledriver.quit();
	}

	@Test
	public void launchBrowser() {
		mobiledriver.get("http://appium.io/");
		Assert.assertEquals(mobiledriver.getCurrentUrl(), "http://appium.io/", "URL Mismatch");
		Assert.assertEquals(mobiledriver.getTitle(), "Appium: Mobile App Automation Made Awesome.", "Title Mismatch");
	}
}
