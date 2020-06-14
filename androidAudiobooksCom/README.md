# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Appium-blue">](https://appium.io/) [<img src="https://img.shields.io/badge/-Android-red">](https://www.android.com/intl/en_uk/)

## Audiobooks.com App Automation
Use free audiobook and podcasts application to run Appium software automation test script. This sample provides a Android TestNG based test project that can be imported as a Maven project on Eclipse or Intellij IDE.
- deviceName & udid: Connect your android device with PC and get device name by running adb devices command in command prompt.
- platformVersion: In the android device, Open settings -> About phone -> Android version.
- appPackage: Package name for the R2 Reader app is org.readium.r2reader.
- appActivity: Activity name for the R2 Reader app is org.readium.r2.testapp.CatalogActivity.

### Reference
- [Google Play: Audiobooks.com](https://play.google.com/store/apps/details?id=com.audiobooks.androidapp&hl=en_GB)

### Running the Test
To run the test;
- install R2 Reader .apk to either Android Emulator or Android Device.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.

### scrollIntoView Shelve Function
```java
// initial scrollIntoView function
mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	+ ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()"
	+ ".textContains(\"Featured Free Fiction Audiobooks\").instance(0))");
	
// failsafe added to the scrollIntoView function
public void scrollToShelve() {
	try {
		mobiledriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
			+ ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()"
			+ ".textContains(\"Featured Free Fiction Audiobooks\").instance(0))");
		System.out.println("Test Status: scrolled to shelve");
	 }catch (Exception e){
		System.out.println("Test Status: shelve not found");
	}
}
```

### Cleanup with "Assert.assertEquals" for sort options
```java
// initial Assert.assertEquals
MobileElement sort_text1_one = mobiledriver.findElement(audiobooks_sort_text1_one);
Assert.assertEquals(sort_text1_one.getText(), "Publication Date", "Test Status: getText assertion failed!");
MobileElement sort_text1_two = mobiledriver.findElement(audiobooks_sort_text1_two);
Assert.assertEquals(sort_text1_two.getText(), "Recently Added", "Test Status: getText assertion failed!");
MobileElement sort_text1_three = mobiledriver.findElement(audiobooks_sort_text1_three);
Assert.assertEquals(sort_text1_three.getText(), "Highest Rated", "Test Status: getText assertion failed!");
MobileElement sort_text1_four = mobiledriver.findElement(audiobooks_sort_text1_four);
Assert.assertEquals(sort_text1_four.getText(), "Best Selling this Month", "Test Status: getText assertion failed!");
MobileElement sort_text1_five = mobiledriver.findElement(audiobooks_sort_text1_five);
Assert.assertEquals(sort_text1_five.getText(), "Book Title [A-Z]", "Test Status: getText assertion failed!");
MobileElement sort_text1_six = mobiledriver.findElement(audiobooks_sort_text1_six);
Assert.assertEquals(sort_text1_six.getText(), "Book Title [Z-A]", "Test Status: getText assertion failed!");
	
// cleanup Assert.assertEquals
WebElement arrayMobileElements [] = {
	mobiledriver.findElement(audiobooks_sort_text1_one),
	mobiledriver.findElement(audiobooks_sort_text1_two),
	mobiledriver.findElement(audiobooks_sort_text1_three),
	mobiledriver.findElement(audiobooks_sort_text1_four),
	mobiledriver.findElement(audiobooks_sort_text1_five),
	mobiledriver.findElement(audiobooks_sort_text1_six),
};
	    
String arrayExpectedValues [] = {
	"Publication Date",	"Recently Added",	"Highest Rated",
	"Best Selling this Month",	"Book Title [A-Z]",	"Book Title [Z-A]",
};
	    
for(int i = 0; i <= arrayMobileElements.length-1; i++)
{
	Assert.assertEquals(arrayMobileElements[i].getText(), arrayExpectedValues[i], "Test Status: getText assertion failed!");
}  
```

#### [Return: Automation Selenium README](../README.md)