# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/)

## Basic Web Automation

### Reference
- [First Selenium Webdriver Script: JAVA Code Example](https://www.guru99.com/first-webdriver-script.html)

### Introduction
Create a WebDriver script that would:
- fetch Google Search homepage
- verify its title
- print out the result of the comparison
- close it before ending the entire program

<details>
<summary>WebDriver Code</summary>
<p>

```java
package testSafari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;  

public class firstTest {

    public static void main(String[] args) {
        // instantiation driver object
        WebDriver driver = new SafariDriver();
        // URL, expected/actual titles are specified as parameters
        String baseUrl = "http://www.google.co.uk/";
        String expectedTitle = "Google";
        String actualTitle = "";
        // launch web browser and direct it to the base URL
        driver.get(baseUrl);
        // get the actual value of the title
        actualTitle = driver.getTitle();
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        // close web browser
        driver.close();  
    }
}
```

</p>
</details>

### Running the Test
There are two ways to execute code in Eclipse IDE:
- On Eclipse's menu bar, click Run > Run
- Press Ctrl+F11 to run the entire code

#### [Return: Automation Selenium README](../README.md)