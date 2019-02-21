package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Home_Page;
import pages.Shop_Page;

public class Shop_Dresses_Test extends BaseTest {

	Shop_Page sp;
	Home_Page hp;
	
	@Parameters({ "email", "password" })
	@Test(enabled = true)
	public void buyDress_MaxRate(String email, String password) {
		hp = new Home_Page(driver);
		sp = new Shop_Page(driver);
		
		//Navigate to the url & Login
		driver.get(url);
		hp.Login_Valid(email, password);
		
		//Add the highest priced dress to the cart
		sp.shop_Dresses();
		hp.checkCart_ProductCount("1");
		
		//Logout from the account
		hp.LogoutfromAccount();
		
		//Log back in to the account & validate the product still in the cart
		hp.Login_Valid(email, password);
		hp.checkCart_ProductCount("1");
	}
	
	@AfterTest
	public void Exit() {
		driver.quit();
	}

}
