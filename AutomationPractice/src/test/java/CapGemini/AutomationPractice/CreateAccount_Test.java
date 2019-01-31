package CapGemini.AutomationPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccount_Test extends BaseTest {

	Home_Page hp;

	//Use the xml parameters to create the account
	@Parameters({"email", "password"})
	@Test
	public void signin_CreateAccount(String email, String password) {

		driver.get(url);
		hp = new Home_Page(driver);
		hp.createAccount(email, password);
	}
	
	@AfterTest
	public void Exit() {
		driver.quit();
	}
}
