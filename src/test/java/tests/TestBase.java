package tests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.Logs;
import utilities.SecureUtil;

public class TestBase {

	// WebDriver
	public static WebDriver driver;

	// Properties files
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	/**
	 * this method returns WebElement for the ORLocator string provided.
	 * 
	 * @param orLocator
	 * @return
	 */
	public WebElement getElement(String orLocator) {
		WebElement el = null;
		By by = getBy(orLocator);
		el = driver.findElement(by);
		
		
		return el;
	}

	public List<WebElement> getElements(String orLocator) {
		List<WebElement> els = null;
		By by = getBy(orLocator);
		els = driver.findElements(by);
		return els;

	}

	private By getBy(String orLocator) {
		String loc = OR.getProperty(orLocator);
		By by = null;
		if (orLocator.startsWith("id")) {
			by = By.id(loc);
		} else if (orLocator.startsWith("xpath")) {
			by = By.xpath(loc);
		} else if (orLocator.startsWith("css")) {
			by = By.cssSelector(loc);
		} else if (orLocator.startsWith("link")) {
			by = By.linkText(loc);
		} else if (orLocator.startsWith("name")) {
			by = By.name(loc);
		} else if (orLocator.startsWith("class")) {
			by = By.className(loc);
		}

		return by;
	}

	public void sendKeys(String orLocator, String value, String elementName) {
		Logs.log("Entering " + value + " at " + elementName + " (OR Locator: " + orLocator + ")");
		getElement(orLocator).sendKeys(value);
	}

	public void typePassword(String orLocator, String encryptedPassword, String elementName) {
		Logs.log("Entering Password at " + elementName + " (OR Locator: " + orLocator + ")");
		getElement(orLocator).sendKeys(SecureUtil.getDecodedString(encryptedPassword));
	}

	public void click(String orLocator, String elementName) {
		Logs.log("Clicking on " + elementName + " (OR Locator: " + orLocator + ")");
		getElement(orLocator).click();
	}

	public void assertText(String orLocator, String textToVerify, String elementName) {
		Logs.log("Asserting text is '" + textToVerify + "' at (OR Locator: " + orLocator + ")");
		Assert.assertEquals(getElement(orLocator).getText(), textToVerify);
	}
	
	/**
	 * This method implements driver.get(URL)
	 * @param URL
	 */
	public void getURL(String URL) {
		Logs.log("Opening URL: " + URL);
		driver.get(URL);
	}

}
