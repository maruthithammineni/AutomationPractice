package CapGemini.AutomationPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Test extends BaseTest {

	Home_Page hp;

	@Parameters({ "email", "password" })
	@Test(enabled = true)
	public void Login_Successful(String email, String password) {

		driver.get(url);
		hp = new Home_Page(driver);
		hp.Login_Valid(email, password);
	}

	@AfterTest
	public void Exit() {
		driver.quit();
	}
}
