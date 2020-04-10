# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Appium-blue">](https://appium.io/) [<img src="https://img.shields.io/badge/-Android-red">](https://www.android.com/intl/en_uk/)

## First Android Appium Automation
With Appium, you would need to write automation test scripts that interact with the screens and controls (buttons, text boxes etc) in your mobile app and perform actions on them. We would use Java to write these automation scripts.
- Step 1: Java Installation and Setup
  - Download and Install latest version of Java (JDK)
  - Setup Java Environment Variables
- Step 2: Android Installation and Setup
  - Download and Install Appium Desktop App
  - Install additional Android SDK tools
  - Setup Android Environment Variables
- Step 3: Appium tool setup
  - Download and Install Appium Desktop App
  - Download and Install Eclipse IDE for Java
  - Turn On USB Debugging on your Android Device
  - Create new project in Eclipse for Appium
- Step 4: ChromeDriver setup
  - Download Chromedriver
  - Add path to Appium Desktop App

### Reference
- [Appium: Mobile App Automation Made Awesome.](http://appium.io/)
- [Tutorial: Automated Testing on Android (with Appium, TestNG and Java on Mac)](https://medium.com/2359media/tutorial-automated-testing-on-android-and-ios-with-appium-testng-and-java-on-mac-210119edf323)

### Running the Test
To run the test;
- download webdriver and note the path, provide the path via Appium GUI.
- launch either Android Emulator or Android Device depending on setup.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.

### Automating Android Emulator
<img src="firstAppium.gif">

#### [Return: Automation Selenium README](../README.md)