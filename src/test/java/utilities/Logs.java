package utilities;

import org.testng.Reporter;

public class Logs {
	public final String L_Fail = "FAIL";
	public final String L_Warn = "WARN";

	public static void log(String text) {
		System.out.println(text);
		Reporter.log(text);
	}

}
