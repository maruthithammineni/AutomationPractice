package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.Home_Page;
import tests.BaseTest;

public class LoginSteps extends BaseTest {
	
//	Home_Page hp;
	
//	public void LoginSteps(WebDriver driver) {
//		hp = new Home_Page(driver);
//	}
	
	@Given("^Click on Signin$")
	public void  click_on_signin() {
		Setup();
		Home_Page hp;
		driver.get(url);
		hp = new Home_Page(driver);
		hp.click_Signin();
	}

	
}
