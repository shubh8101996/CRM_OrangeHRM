package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.utility.ReadProperties_Utility;

public class Base {

	public static WebDriver driver;
	ReadProperties_Utility read = new ReadProperties_Utility();

	public String projectPath = System.getProperty("user.dir");
	public String browser = read.getBrowserValue();
	public String url = read.getUrl();


	@BeforeClass
	public void browserSetup() {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\browser_drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					projectPath + "\\browser_drivers\\edgedriver\\msedgedriver.exe");
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					projectPath + "\\browser_drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {

			System.out.println("Invalid browser value");
		}

	}

	@AfterClass
	public void tearUp() {

		driver.quit();

	}

}