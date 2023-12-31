package com.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Dashboard_Page;
import com.page_class.Login_Page;
import com.reports.ExtentReportListener;
import com.utility.ReadProperties_Utility;
import com.utility.Utility;

import bsh.util.Util;

@Listeners(ExtentReportListener.class)
public class TC_01 extends Base {

	ReadProperties_Utility read = new ReadProperties_Utility();
	Login_Page login;
	Dashboard_Page dashboard;

	@Test(description = "Verify login with valid ESS username and valid password.")
	public void Test1() throws InterruptedException {

		login = new Login_Page(driver);
		dashboard = new Dashboard_Page(driver);

		Utility.maximizeWindow(driver);
		driver.get(url);
		login.enterCredLogin();
		login.clickLoginBtn();
		Utility.assertTextEqualsByElementText(driver, dashboard.DashboardText, "TextDashboard", 3);
		Utility.captureScreenshot(driver, "TC_01");

	}

}
