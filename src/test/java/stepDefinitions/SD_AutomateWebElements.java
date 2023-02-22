package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	@Then("User selects radio button of {string}")
	public void user_selects_radio_button_of(String string) {
		driver.findElement(By.xpath(OR.getProperty("xpath_SeniorCitizen").replace("Senior", string))).click();
		// click("xpath_SeniorCitizen","Radio Button of senior citizen");
	}

	@Then("Verify checkbox of {string} is selected")
	public void verify_checkbox_of_is_selected(String string) {
		boolean bool = driver.findElement(By.xpath("//input[@type='checkbox'][@value='option1']")).isSelected();
		System.out.println("Checkbox of option1 is selected: " + bool);
		Assert.assertEquals(bool, true);
	}

	@Then("Get the count of checkboxes present on the page")
	public void get_the_count_of_checkboxes_present_on_the_page() {
		// Write code here that turns the phrase above into concrete actions

		int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("Count of checkboxes: " + count);
	}

	@Given("User selects checkbox of {string}")
	public void user_selects_checkbox_of(String string) {
		driver.findElement(By.xpath("//input[@type='checkbox'][@value='option1']")).click();
	}

	@Then("User selects today's date on calendar")
	public void user_selects_today_s_date_on_calendar() throws InterruptedException {
		click("xpath_datePicker", "Date Picker");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);
		String monthName = (new SimpleDateFormat("MMMM YYYY").format(cal.getTime()));
		String todaysDate = (new SimpleDateFormat("d").format(cal.getTime()));
		System.out.println(monthName);
		System.out.println(todaysDate);

		// Get list of Month Names first to compare
		List<WebElement> monthelements = driver
				.findElements(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		for (WebElement mon : monthelements) {
			System.out.println("Checking: " + mon.getText());
			if (mon.getText().equalsIgnoreCase(monthName)) {

				// Navigate to proper parent where from we can go to the date

				WebElement parentMonthEl = mon.findElement(By.xpath("../.."));

				// navigate relatively to the proper date
				parentMonthEl.findElement(By.xpath(".//div[contains(text(),'" + todaysDate + "')]")).click();
				String selectedDate = driver
						.findElement(By.xpath("//div[contains(text(),'Departure Date')]/../div[2]/div[1]")).getText();

				System.out.println("Selected Date: " + selectedDate);
				break;
			}

		}

	}

	@Given("user is on the home page of Angular practice Page")
	public void user_is_on_the_home_page_of_angular_practice_page() {
		getURL(config.getProperty("baseURLAngular"));
	}

	@Given("User enters following data {string} ,{string}, {string}, {string}, {string}, {string}, {string} and submits")
	public void user_enters_following_data_and_submits(String name, String email, String password, String check,
			String gender, String employmentStatus, String dateOfBirth) {
		sendKeys("tagName_input", name, "Name");
		sendKeys("name_email", email, "Email");
		sendKeys("id_password", password, "Password");
		if (check.equalsIgnoreCase("true")) {
			click("id_check", "Checkbox");
		}

		Select dd = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		dd.selectByVisibleText(gender);

		List<WebElement> radios = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));

		for (WebElement radioParent : radios) {
			String radioLable = radioParent.findElement(By.xpath("./label")).getText();
			if (radioLable.equalsIgnoreCase(employmentStatus)) {
				radioParent.findElement(By.xpath("./input")).click();
				break;
			}
		}

		click("name_bday", "Date of Birth");
		sendKeys("name_bday", dateOfBirth, "Date of Birth");

		click("xpath_submitButton", "Submit Button");
	}

	@Then("verify user receives success message")
	public void verify_user_receives_success_message() {
		System.out.println(driver.findElement(By.xpath(OR.getProperty("xpath_SuccessMessage"))).getText());
	}

	@Given("user clicks on Alert button on practice page")
	public void user_clicks_on_alert_button_on_practice_page() {
		driver.findElement(By.id("alertbtn")).click();
	}

	@Then("verify user is prompted by an alert")
	public void verify_user_is_prompted_by_an_alert() {
		String alertText = driver.switchTo().alert().getText();
		System.out.println("alert text: " + alertText);

		// accept the alert
		driver.switchTo().alert().accept();

	}

	@Then("user clicks on confirm button on practice page")
	public void user_clicks_on_confirm_button_on_practice_page() {
		driver.findElement(By.id("confirmbtn")).click();
	}

	@Then("verify user is able to dismiss the alert")
	public void verify_user_is_able_to_dismiss_the_alert() {
		String alertText = driver.switchTo().alert().getText();
		System.out.println("alert text: " + alertText);

		// dismiss the alert
		driver.switchTo().alert().dismiss();
		;
	}
}
