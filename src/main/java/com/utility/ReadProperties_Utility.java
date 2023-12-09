package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties_Utility {

	public Properties properties;
	String propertiesFilePath = System.getProperty("user.dir")
			+ "\\TestData\\properties_file\\env_sit_config.properties";

	public ReadProperties_Utility() {

		properties = new Properties();

		try {
			FileInputStream file = new FileInputStream(propertiesFilePath);
			properties.load(file);
		} catch (Exception e) {

			System.out.println("Wrong file path");

		}

	}

	public String getBrowserValue() {

		String browserVal = properties.getProperty("browser");

		return browserVal;

	}

	public String getUrl() {

		String Baseurl = properties.getProperty("url");

		return Baseurl;

	}

	public String getUsername() {

		String username = properties.getProperty("username");

		return username;

	}

	public String getPassword() {

		String password = properties.getProperty("password");

		return password;

	}

}
