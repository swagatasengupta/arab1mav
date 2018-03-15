package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Properties;

public class UtilLib {

	public static Properties getPropertiesFile(String propRelPath) throws IOException {

		String absPath = new File(propRelPath).getAbsolutePath();
		System.out.println("Abs path: " + absPath);
		FileInputStream fis = new FileInputStream(absPath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}

	public static String fetchPath(String pathCode) {
		String pathToReturn = null;
		switch (pathCode.trim().toUpperCase()) {
		case "AUTOP_PROP_FILE":
			pathToReturn = "resources/autop.properties";
			break;
		default:
			pathToReturn = null;
		}
		System.out.println("returning file: " + pathToReturn);
		return pathToReturn;
	}

	public static String decodeString(String encodedString) {

		return (new String(Base64.getDecoder().decode(encodedString)));
	}

	public static String encodeString(String unencodedString) {

		return (new String(Base64.getEncoder().encode(new String(unencodedString).getBytes())));

	}

	public static String getTimeStamp(String pattern) {
		if (pattern==null) {
			pattern = "yyyyMMddHHmmss";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now); 
	}
	public static String getTimeStamp() {
		return getTimeStamp(null);
	}

}
