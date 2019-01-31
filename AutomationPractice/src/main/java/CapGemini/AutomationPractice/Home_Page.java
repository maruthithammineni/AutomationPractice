package CapGemini.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Home_Page {

	WebDriver driver;
	Framework_CoreFunctions cf;

	By lnk_Signin = By.linkText("Sign in");
	By lnk_Signout = By.xpath("//a[@title='Log me out']");

	By txt_Email_Create = By.id("email_create");
	By btn_CreateAccount = By.id("SubmitCreate");

	By txt_Email_Login = By.id("email");
	By txt_Password_Login = By.id("passwd");
	By btn_Login = By.name("SubmitLogin");

	By lbl_CartQuantity = By.xpath("//span[@class='ajax_cart_quantity unvisible']");

	By rdb_Title_Mr = By.id("id_gender1");
	By rdb_Title_Mrs = By.id("id_gender2");

	// for the Personal Information
	By txt_FirstName = By.id("customer_firstname");
	By txt_LastName = By.id("customer_lastname");
	By txt_Email = By.id("email");
	By txt_Password = By.id("passwd");
	By lst_Date = By.id("days");
	By lst_Month = By.id("months");
	By lst_Year = By.id("years");

	// for the Address
	By txt_Address_First = By.id("firstname");
	By txt_Address_Last = By.id("lastname");
	By txt_Address_Line1 = By.id("address1");
	By txt_Address_Line2 = By.id("address2");
	By txt_Address_City = By.id("city");
	By lst_State = By.id("id_state");
	By txt_PostCode = By.id("postcode");
	By lst_Country = By.id("id_country");
	By txt_HomePhone = By.id("phone");
	By txt_MobilePhone = By.id("phone_mobile");
	By txt_Address_Alias = By.id("alias");
	By btn_Register = By.id("submitAccount");

	By lbl_Welcome = By.xpath("//p[@class='info-account' and contains(text(), 'Welcome to your account')]");

	// Constructor defined to pass the driver
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		cf = new Framework_CoreFunctions(driver);
	}

	// click on the sign in Link & wait to load
	public void click_Signin() {
		cf.clickElement(lnk_Signin);
		cf.waitforElement(btn_Login, 10);
	}

	// create new account by inputing the required information
	// email & password are parametrised, more can be done if needed
	public void createAccount(String email, String password) {

		click_Signin();

		// Enter the email address and click on Create Account
		cf.setTextBox(txt_Email_Create, email);
		cf.clickElement(btn_CreateAccount);
		cf.waitforElement(btn_Register, 20);

		// Enter the personal information
		cf.clickElement(rdb_Title_Mr);
		cf.setTextBox(txt_FirstName, "Maruthi");
		cf.setTextBox(txt_LastName, "Thammineni");
		
		//Verify the email enter in the previous screen is auto populated 
		String email_display = cf.getAttribute_Element(txt_Email, "value");
		cf.compareValues(email, email_display);
		cf.setTextBox(txt_Password, password);
		cf.select_dropdown(lst_Date, "value", "10");
		cf.select_dropdown(lst_Month, "visibleText", "January ");
		cf.select_dropdown(lst_Year, "value", "1985");

		// Enter the address details
		cf.setTextBox(txt_Address_Line1, "Pre Interview");
		cf.setTextBox(txt_Address_Line2, "Capgemini");
		cf.setTextBox(txt_Address_City, "Test City");
		cf.select_dropdown(lst_State, "visibleText", "Alabama");
		cf.setTextBox(txt_PostCode, "35505");
		cf.setTextBox(txt_MobilePhone, "0044 7582141603");
		cf.setTextBox(txt_Address_Alias, "Home");

		cf.clickElement(btn_Register);
		cf.waitforElement(lbl_Welcome, 20);

		if (cf.getElement(lbl_Welcome).isDisplayed()) {
			Reporter.log("Signup successful: " + cf.getElement(lbl_Welcome).getText());
		}
	}

	// To Login with valid email & password
	public void Login_Valid(String email, String password) {
		click_Signin();

		// Enter the email address,Password and click on Sign in
		cf.setTextBox(txt_Email_Login, email);
		cf.setTextBox(txt_Password_Login, password);
		cf.clickElement(btn_Login);

		// Wait till the login is successful & verify the welcome message
		cf.waitforElement(lbl_Welcome, 20);
		if (cf.getElement(lbl_Welcome).isDisplayed()) {
			Reporter.log("Login successful: " + cf.getElement(lbl_Welcome).getText());
		}

	}
	
	// To logout whenalready logged in to an account
	public void LogoutfromAccount() {
	
		cf.clickElement(lnk_Signout);
		cf.waitforElement(lnk_Signin, 10);
		Reporter.log("Logged out from the account successfully !!!");
	}
	
	//To verify the product count in the cart at any point of time
	public void checkCart_ProductCount (String productCount) {
		
		String cartCnt = cf.getAttribute_Element(lbl_CartQuantity, "text");
		
		if (cartCnt.contentEquals(productCount))			
			Reporter.log(" Product count in the cart matches : " + cartCnt);
		else
			Assert.fail(" Product count in the cart does not match. Expected : " + productCount + " Actual : " + cartCnt);
	}
}
