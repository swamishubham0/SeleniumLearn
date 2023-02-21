package stepDefinitions;

import java.util.List;

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
}
