package CapGemini.AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BaseTest {
	
	WebDriver driver;
	public String url = "http://automationpractice.com/index.php";

	// Method to launch the browser as required
	//can be customised to pass browser parm
	@Test
	public void Setup() {

		String FFDriverPath = System.getProperty("user.dir") + "/src/drivers/geckodriver";
		System.setProperty("webdriver.gecko.driver", FFDriverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

}
