package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tests.TestBase;

public class SD_AutomateWebElements extends TestBase {
	Select dd;

	@Given("user is on the home page of Practice Page")
	public void user_is_on_the_home_page_of_practice_page() {
		getURL(config.getProperty("baseURLPractice"));
	}

	@Given("User verifies there are {int} options in the dropdown")
	public void user_verifies_there_are_options_in_the_dropdown(int noOfOptions) {
		// Get list of elements available in the dropdown
		List<WebElement> options;
		WebElement dropdown = getElement("id_ddExample");

		dd = new Select(dropdown);
		options = dd.getOptions();

		Assert.assertEquals(options.size(), noOfOptions);

	}

	@Then("user selects {string} from the Dropdown")
	public void user_selects_from_the_dropdown(String string) {
		dd.selectByVisibleText(string);
	}

	@Given("user is on the home page of Dropdown Practice Page")
	public void user_is_on_the_home_page_of_dropdown_practice_page() {
		getURL(config.getProperty("baseURL_DDPractice"));
	}

	@Given("User enters {string} in the dropdown search field")
	public void user_enters_in_the_dropdown_search_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User selects {string} from the autosuggest dropdown")
	public void user_selects_from_the_autosuggest_dropdown(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("user is on the home page of SpiceJet Page")
	public void user_is_on_the_home_page_of_spice_jet_page() {
		getURL(config.getProperty("baseURL_SpiceJet"));
	}

	@Then("User selects checkbox of {string}")
	public void user_selects_checkbox_of(String string) {
		driver.findElement(By.xpath(OR.getProperty("xpath_SeniorCitizen").replace("Senior", string))).click();
		//click("xpath_SeniorCitizen","Radio Button of senior citizen");
	}
}
