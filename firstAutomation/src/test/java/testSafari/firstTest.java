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