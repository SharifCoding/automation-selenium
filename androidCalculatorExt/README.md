# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Appium-blue">](https://appium.io/) [<img src="https://img.shields.io/badge/-Android-red">](https://www.android.com/intl/en_uk/)

## Google Calcultor App Automation - Part 2
Use Android mobile phone's default installed Calculator app to run Appium software automation test script. This sample provides a Android TestNG based test project that can be imported as a Maven project on Eclipse or Intellij IDE.
- deviceName & udid: Connect your android device with PC and get device name by running adb devices command in command prompt.
- platformVersion: In the android device, Open settings -> About phone -> Android version.
- appPackage: Package name for the calculator app is com.android.calculator2.
- appActivity: Activity name for the calculator app is com.android.calculator2.Calculator.

### Reference
- [Google: Android Calculator](https://play.google.com/store/apps/details?id=com.google.android.calculator&hl=en_GB)

### Running the Test
To run the test;
- install Google Calculator .apk to either Android Emulator or Android Device.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.

### Note
Following error message <b>may</b> appear when attempting to open the calculator advanced menu:
```json
org.openqa.selenium.InvalidArgumentException: Coordinate [x=1080.0, y=888.0] is outside of element rect: [0,0][1080,1776]
```
Please adjust the <b>x</b> and <b>y</b> position depending on you android device.
```java
Dimension size = mobiledriver.manage().window().getSize();
int xOffset_pad_advanced = (int) (size.getWidth() * 0.95);
int yOffset_pad_advanced = (int) (size.getHeight() * 0.65);
new TouchAction<>(mobiledriver).tap(PointOption.point(xOffset_pad_advanced, yOffset_pad_advanced)).perform();
```

#### [Return: Automation Selenium README](../README.md)