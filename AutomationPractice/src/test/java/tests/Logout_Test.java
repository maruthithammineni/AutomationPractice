package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Home_Page;

public class Logout_Test extends BaseTest {

	Home_Page hp;

	@Parameters({ "email", "password" })
	@Test(enabled = true)
	public void Login_Logout(String email, String password) {
		
		driver.get(url);
		hp = new Home_Page(driver);
		hp.Login_Valid(email, password);
		hp.LogoutfromAccount();
	}
	
	@AfterTest
	public void Exit() {
		driver.quit();
	}

}
