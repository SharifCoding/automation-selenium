# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-Allure_Reporting-gold">](http://allure.qatools.ru/) [<img src="https://img.shields.io/badge/-SimepleJSON-blue">](https://simplejson.readthedocs.io/en/latest/)

## Adding Allure Reporting to Automation
Allure Framework is a flexible lightweight multi-language test report tool that shows a very concise representation of what have been tested in a neat web report form.

### Reference
- [Allure Framework](https://docs.qameta.io/allure/)

### Running the Test
To run the test;
- download webdriver and note the path, provide the path on the java test file and save.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.
- input command __allure serve allure-results__ to generate an Allure Report.
- for troubleshooting place __categories.json__ file into the folder __allure-results__.

### Results of Allure Report
<img src="resultAllureReport.jpg" width="800">

#### [Return: Automation Selenium README](../README.md)