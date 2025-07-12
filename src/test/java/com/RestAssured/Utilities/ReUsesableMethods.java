package com.RestAssured.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReUsesableMethods {

	public String GetFilepath(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream input = null;

		input = new FileInputStream(
				"C:\\Users\\mechk\\Downloads\\Learning\\RestAssured\\src\\test\\java\\com\\RestAssured\\Config\\Config.properties");

		prop.load(input);
		return prop.getProperty(key);

	}

}
