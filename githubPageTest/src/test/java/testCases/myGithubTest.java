package testCases;
 
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mainPages.myGithubPage;
 
public class myGithubTest extends baseTest{
	
	@Test (priority = 0)
	@Severity (SeverityLevel.CRITICAL) // BLOCKER, CRITICAL, NORMAL, MINOR, TRIVIAL
	@Feature ("Github Pages")
	@Description ("The Github Pages is loaded.")
    public void myGithubPageIsLoaded () throws InterruptedException {
 
        //*************PAGE INSTANTIATIONS*************
		myGithubPage myGithubTest = new myGithubPage(browser);
 
        //*************PAGE METHODS********************
		myGithubTest.launch_my_github_page();
		myGithubTest.check_title_of_page();
		myGithubTest.github_button_shown();
		myGithubTest.blogger_button_shown();
		myGithubTest.email_me_button_shown();
		myGithubTest.homer_over_each_projects();
		myGithubTest.scroll_to_about_me_container();
		myGithubTest.grab_title_tag_from_each_image();
		myGithubTest.scroll_to_experince_container();
		myGithubTest.scroll_to_copyright_container();
		myGithubTest.validate_copyright_date();
    }
}