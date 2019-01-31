package CapGemini.AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Framework_CoreFunctions {

	WebDriver driver;

	// Construction to pass the driver
	public Framework_CoreFunctions(WebDriver driver) {
		this.driver = driver;
	}

	// Get the web element given the locator from page
	public WebElement getElement(By strElement) {

		WebElement element = null;
		List<WebElement> list = driver.findElements(strElement);
		int size = list.size();

		if (size == 1)
			element = list.get(0);
		else if (size == 0)
			Assert.fail("No elements found on the page with identification : " + strElement);
		else
			Assert.fail("More than one element found on the page with identification : " + strElement);

		return element;
	}

	// wait for an element to be visible on the page
	public void waitforElement(By strElement, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(strElement));
	}

	// Set the text box with the required value
	public void setTextBox(By strElement, String value) {

		WebElement element = getElement(strElement);
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			element.clear();
			element.sendKeys(value);
			Reporter.log("Text box value set as : " + value);
		}
	}

	// Click on the element i.e. link or button etc
	public void clickElement(By strElement) {

		WebElement element = getElement(strElement);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				element.click();
				Reporter.log("Clicked on element with identification : " + strElement);
			} else {
				Assert.fail("Element is displayed but not enabled. Identification :  " + strElement);
			}
		}
	}

	// get required attribute value of the element
	public String getAttribute_Element(By strElement, String attributeType) {

		String attrValue = null;

		WebElement element = getElement(strElement);

		switch (attributeType.trim().toLowerCase()) {

		case "value":
			attrValue = element.getAttribute("value");
			break;

		case "id":
			attrValue = element.getAttribute("id");
			break;

		case "text":
			attrValue = element.getText();
			break;

		default:
			Assert.fail(" Invalid attribute type is mentione : " + attributeType);
		}

		return attrValue;
	}

	// select the drop down using different selection methods & values
	public void select_dropdown(By strElement, String selectionType, String value) {

		String type = selectionType.trim().toLowerCase();

		WebElement element = getElement(strElement);
		Select sel = new Select(element);

		switch (type) {

		case "value":
			sel.selectByValue(value);
			break;

		case "index":
			sel.selectByIndex(Integer.parseInt(type));
			break;

		case "visibletext":
		case "displayedtext":
			sel.selectByVisibleText(value);
			break;

		default:
			Assert.fail("Invalid selection type given : " + selectionType);
		}

	}
	
	//compare values
	public void compareValues(String expected, String actual) {
		if (expected.trim().equalsIgnoreCase(actual))
			Reporter.log( "Value match : " + actual);
		else
			Reporter.log(" Value match failed. Expected : " + expected + " Actual : " + actual);
			//can be customised to fail the test if needed
	}
}
