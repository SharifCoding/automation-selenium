# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html)

## TestNG and multiple WebDriver support
Selenium WebDriver drives a browser natively, as a real user would, either locally or on remote machines. WebDriver can be used with all major browsers. Automate real user interactions in Chrome, Firefox, Edge, Safari, Internet Explorer and more!

### Reference
- [What is Selenium WebDriver?](https://www.guru99.com/introduction-webdriver-comparison-selenium-rc.html)

### Introduction
Added a parameter to TestNG indicating prefer web browser, __@BeforeClass__ will go through if else statement to match with parameter otherwise trigger an error console log message. The desired browser will launch and then run the test script as follow:
- fetch Google Search homepage
- verify its title
- print out the result of the comparison
- close it before ending the entire program

```java
...
if (mBrowser.equalsIgnoreCase("Chrome")) {
    System.setProperty("webdriver.chrome.driver", "Absolute path of Chrome driver");   
    driver = new ChromeDriver();
    System.out.println("Initiating Google Chrome webdriver");       
}
else if (mBrowser.equalsIgnoreCase("Firefox")) {
    System.setProperty("webdriver.gecko.driver", "Absolute path of Firefox driver");   
    driver = new FirefoxDriver();
    System.out.println("Initiating Mozilla Firefox webdriver");
}
...
```

### Running the Test
To run the test;
- download webdriver and note the path, provide the path on the java test file and save.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__. Eclipse will provide two outputs; one in the Console window, and the other on the TestNG Results window.

<img src="https://www.guru99.com/images/WebDriver_and_Browsers(1).jpg">

#### [Return: Automation Selenium README](../README.md)