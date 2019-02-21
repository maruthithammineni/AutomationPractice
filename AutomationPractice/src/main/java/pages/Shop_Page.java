package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import resources.Framework_CoreFunctions;

public class Shop_Page {

	WebDriver driver;
	Framework_CoreFunctions cf;

	By lnk_Home = By.xpath("//a[@title='Return to Home']");
	By lnk_Dresses = By.xpath("//a[@class='sf-with-ul' and @title = 'Dresses']");

	By btn_Compare_Bottom = By.xpath("//button[contains(@class,'bt_compare_bottom')]");

	By lbl_ProdPrice = By.xpath("//span[@class='price product-price' and @itemprop = 'price']");
	
	By txt_Quantity = By.id("quantity_wanted");
	By btn_AddtoCart = By.name("Submit");
	
	By btn_ContinueShopping = By.xpath("//span[@title = 'Continue shopping']");
	By btn_CheckOut = By.xpath("//span[text() = 'Proceed to checkout']");
	
	// Constructor defined to pass the driver
	public Shop_Page(WebDriver driver) {

		this.driver = driver;
		cf = new Framework_CoreFunctions(driver);

	}

	// click on the sign in Link & wait to load
	public void shop_Dresses() {
		
		//Naviagate to the Dresses
		WebElement maxPriceElement = null;
		driver.findElements(lnk_Dresses).get(1).click();
		cf.waitforElement(btn_Compare_Bottom, 30);

		// Parse through all the prices to find the maximum
		List<WebElement> prices = driver.findElements(lbl_ProdPrice);

		double maxPrice = 0.00;

		for (WebElement price : prices) {
//			System.out.println(price.getText());
			String strPrice = price.getText();
			if (!strPrice.isEmpty()) {
				strPrice = strPrice.replace("$", "");
				double prodPrice = Double.parseDouble(strPrice);
//				System.out.println(prodPrice);

				if (prodPrice > maxPrice) {
					maxPrice = prodPrice;
					maxPriceElement = price;
				}
			}
		}
		Reporter.log("Max Price found on the website : " + maxPrice);
		
//		Once the maximum price is found click on the related image to add to cart
		maxPriceElement.findElement(By.xpath("./ancestor::div[2]/preceding-sibling::div//img")).click();
		cf.waitforElement(btn_AddtoCart, 20);
		
		cf.setTextBox(txt_Quantity, "1");
		cf.clickElement(btn_AddtoCart);
		cf.waitforElement(btn_ContinueShopping, 20);
		
		cf.clickElement(btn_ContinueShopping);
		Reporter.log("1 Dress added to the cart with amount : " + maxPrice);
		
	}
}
