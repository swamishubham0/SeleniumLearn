package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesSetup {

	public static boolean SetupPropertiesFile(Properties prop, String propFilePath) {
		boolean bSetup = false;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") 
					+ propFilePath 
					);
			prop.load(fis);
			bSetup = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return bSetup;
	}
	
}
