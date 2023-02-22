package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/AutomateWebElements.feature" 				// specify where the feature files are located
		, glue = "stepDefinitions" 									// specify where the stepDefinition files are located
		, plugin = { 
				"progress", "html:target/cucumberReport.html", 		// to generate cucumber reports
				"json:target/cucumberJReport.json", 				// to generate json report
				"junit:target/cucumberJUnitReport.xml" 				// to generate xml report
		
		}
//		,dryRun = true 												// to generate the step definitions
		,tags = "@CheckBox"
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
