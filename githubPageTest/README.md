# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Allure_Reporting-gold">](http://allure.qatools.ru/) [<img src="https://img.shields.io/badge/-SimepleJSON-blue">](https://simplejson.readthedocs.io/en/latest/)

## Personal Github Pages Automation
Github has a feature called Github Pages, which makes it easy and free for you to create a multi-file website hosted at <b>yourusername.github.io</b>.

### Reference
- [Github Pages](https://pages.github.com/)

### Running the Test
To run the test;
- download webdriver and note the path, provide the path on the java test file and save.
- right click the __testng.xml__ file, and then select __Run As > TestNG Suite__.
- input command __allure serve allure-results__ to generate an Allure Report.
- for troubleshooting place __categories.json__ file into the __allure-results__ folder.

### Results of Allure Report
<img src="resultAllureReport.jpg" width="800">

#### [Return: Automation Selenium README](../README.md)