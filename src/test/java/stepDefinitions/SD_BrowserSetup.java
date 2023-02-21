package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.TestBase;
import utilities.Logs;

public class SD_BrowserSetup extends TestBase {
	@Given("Browser is setup")
	public void validate_the_browser() {
		Logs.log("Setting up the browser");
		WebDriverManager.chromedriver().setup();
	}

	@When("Browser is triggered")
	public void browser_is_triggered() {
		Logs.log("Creating Chrome Driver");
		driver = new ChromeDriver();
	}

	@Then("Check if browser is started")
	public void check_if_browser_is_started() {
		Logs.log("Maximizing the window to check if the browser is started.");
		String windowHandle = driver.getWindowHandle();
		Logs.log(windowHandle);
		driver.manage().window().maximize();
	}
}
