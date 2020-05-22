# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Appium-blue">](https://appium.io/) [<img src="https://img.shields.io/badge/-Android-red">](https://www.android.com/intl/en_uk/)

## R2 Reader App Automation
Use free reading application (open-source Readium-2 architecture) to run Appium software automation test script. This sample provides a Android TestNG based test project that can be imported as a Maven project on Eclipse or Intellij IDE.
- deviceName & udid: Connect your android device with PC and get device name by running adb devices command in command prompt.
- platformVersion: In the android device, Open settings -> About phone -> Android version.
- appPackage: Package name for the R2 Reader app is org.readium.r2reader.
- appActivity: Activity name for the R2 Reader app is org.readium.r2.testapp.CatalogActivity.

### Reference
- [Google Play: R2 Reader](https://play.google.com/store/apps/details?id=org.readium.r2reader)

### Running the Test
To run the test;
- install R2 Reader .apk to either Android Emulator or Android Device.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.

### Results of Allure Report
<img src="allureReporting.png" width="800">

#### [Return: Automation Selenium README](../README.md)