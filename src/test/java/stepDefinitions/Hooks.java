package stepDefinitions;

import io.cucumber.java.After;
import tests.TestBase;

public class Hooks extends TestBase{

	@After
	public void AfterWebElementTests() {
		driver.quit();
	}
}
