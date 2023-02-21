package stepDefinitions;

import io.cucumber.java.en.Given;
import tests.TestBase;
import utilities.Logs;
import utilities.PropertiesSetup;

public class SD_PropertiesSetup {
	private boolean propertiesFilesSetupFlag;

	public boolean isPropertiesFilesSetupFlag() {
		return propertiesFilesSetupFlag;
	}

	public void setPropertiesFilesSetupFlag(boolean propertiesFilesSetupFlag) {
		this.propertiesFilesSetupFlag = propertiesFilesSetupFlag;
	}

	@Given("Properties Files are Setup")
	public void properties_files_are_setup() {
		if (!isPropertiesFilesSetupFlag()) {
			if (setupProps_OR() && setupProps_config()) {
				setPropertiesFilesSetupFlag(true);
			}else {
				Logs.log("Error in setting up properties files");
			}

		}
	}

	private boolean setupProps_config() {
		return PropertiesSetup.SetupPropertiesFile(TestBase.config, "\\src\\test\\resources\\properties\\config.properties");
	}

	private boolean setupProps_OR() {
		return PropertiesSetup.SetupPropertiesFile(TestBase.OR, "\\src\\test\\resources\\properties\\OR.properties");
	}

}
