# automation-selenium

[<img src="https://img.shields.io/badge/-Selenium-brightgreen">](https://www.selenium.dev/) [<img src="https://img.shields.io/badge/-Maven-orangered">](hhttps://maven.apache.org/) [<img src="https://img.shields.io/badge/-Eclipse_IDE-orange">](https://www.eclipse.org/) [<img src="https://img.shields.io/badge/-Java-darkred">](https://www.java.com/en/) [<img src="https://img.shields.io/badge/-TestNG-sandybrown">](https://testng.org/doc/index.html) [<img src="https://img.shields.io/badge/-SimepleJSON-blue">](https://simplejson.readthedocs.io/en/latest/)

## Automation with JSON parameters
JSON stands for JavaScript Object Notation. The JSON variable we define is an object, which contains many properties using the key:value structure. It is used to transfer data between a server and a client on the web. JSON Wire Protocol is a REST API that transfers the information between HTTP server. Each BrowserDriver (such as FirefoxDriver, ChromeDriver, etc.) has its own HTTP server. There are two types of JSON formats, Simple JSON and JSON Arrays:

<details>
<summary>Simple JSON</summary>
<p>

Data are stored here in simple text format which can be accessed easily.

```json
var mydetails = {
  "Name" : "Jack",
  "Age" : "30",
  "Gender" : "Male"
};
```

</p>
</details>

<details>
<summary>Array JSON</summary>
<p>

JSON also supports storing multiple sets of data in the form of an Array structure. 

```json
var empdetails = [{
  "Name" : "John",
  "Designation" : "Project Manager",
  "Gender" : "Male"
},
{
  "Name" : "Doe",
  "Designation" : "Team Lead",
  "Gender" : "Male"
}];
```

</p>
</details>

### Reference
- [Data Parameterization Using JSON With Selenium](https://dzone.com/articles/selenium-data-parameterization-using-json)

### Running the Test
To run the test;
- download webdriver and note the path, provide the path on the java test file and save.
- right click the __testNG.xml__ file, and then select __Run As > TestNG Suite__.

#### [Return: Automation Selenium README](../README.md)