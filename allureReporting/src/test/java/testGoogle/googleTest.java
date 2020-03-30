package testGoogle;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainGoogle.googlePage;
 
public class googleTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Google")
	@Description ("The Google Main Search Page Is Loaded.")
    public void googleMainSearchPageIsLoaded () {
 
        //*************PAGE INSTANTIATIONS*************
		googlePage googlePageTest = new googlePage(browser);
 
        //*************PAGE METHODS********************
		googlePageTest.google_site_is_loaded();
		googlePageTest.check_title_of_page();
		googlePageTest.search_input_field_shown();
		googlePageTest.google_search_button_shown();
		googlePageTest.feeling_lucky_button_shown();
		googlePageTest.input_string_to_search_field();
		googlePageTest.google_search_button_shown_two();
		googlePageTest.feeling_lucky_button_shown_two();
		googlePageTest.execute_inputted_string();
		googlePageTest.get_value_from_searched_string();
    }
}