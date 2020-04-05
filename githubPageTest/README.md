# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Allure_Reporting-gold">](http://allure.qatools.ru/) [<img src="https://img.shields.io/badge/-SimepleJSON-blue">](https://simplejson.readthedocs.io/en/latest/)

## Personal Github Pages Automation
Github has a feature called Github Pages, which makes it easy and free for you to create a multi-file website hosted at <b>yourusername.github.io</b>.

### Reference
- [Github Pages](https://pages.github.com/)

<details>
<summary>WebDriver Array</summary>
<p>

#### Before 

```java
@Step ("Hover over each Projects.")
public void homer_over_each_projects() throws InterruptedException {
    ...
    scrollToElement(ProjectOne);
    hoverOverElement(ProjectOne);
    System.out.println("Test Status: Hover to project: nasa-image-search");
    scrollToElement(ProjectTwo);
    hoverOverElement(ProjectTwo);
    System.out.println("Test Status: Hover to project: react-roman-numerals");
    scrollToElement(ProjectThree);
    hoverOverElement(ProjectThree);
    System.out.println("Test Status: Hover to project: react-bootstrap-oxford");
    ...
}
```

#### After 

```java
@Step ("Hover over each Projects.")
public void homer_over_each_projects() throws InterruptedException {
    ...
    WebElement array [] = {
        browser.findElement(ProjectOne),
        browser.findElement(ProjectTwo),
        browser.findElement(ProjectThree),
        ...
    };
    for(int i = 0; i <= array.length-1; i++)
    {
        hoverOverElement(array[i]);
        System.out.println("Test Status: Hover to project: " + array[i].getText());
    }
}
```

</p>
</details>

### Running the Test
To run the test;
- download webdriver and note the path, provide the path on the java test file and save.
- right click the __testng.xml__ file, and then select __Run As > TestNG Suite__.
- input command __allure serve allure-results__ to generate an Allure Report.
- for troubleshooting place __categories.json__ file into the __allure-results__ folder.

### Results of Allure Report
<img src="resultAllureReport.jpg" width="800">

#### [Return: Automation Selenium README](../README.md)