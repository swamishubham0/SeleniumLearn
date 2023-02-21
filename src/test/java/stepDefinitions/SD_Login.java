package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;
import utilities.Logs;

public class SD_Login extends TestBase {

	@Given("User is on SauceDemo Login Page")
	public void user_is_on_sauce_demo_login_page() {
		Logs.log("Navigating to Login page: " + config.getProperty("baseURL"));
		String URL = config.getProperty("baseURL");
		driver.navigate().to(URL);
	}

	@When("User Login to application with username and password")
	public void user_login_to_application_with_username_and_password() {
		sendKeys("id_username", config.getProperty("username"), "user name");
		typePassword("id_pwd", config.getProperty("password"), "password");
		click("name_loginButton", "Login Button");
	}

	@Then("Home page is displayed")
	public void home_page_is_displayed() {
		assertText("xpath_ProductsTitle", "PRODUCTS", "Home Page header - Products");
	}

	@Then("Shopping Items are displayed on the homepage")
	public void shopping_items_are_displayed_on_the_homepage() {
		List<WebElement> els = getElements("class_productNames");
		Logs.log("Products present on the page:" + els.size());
	}
}
