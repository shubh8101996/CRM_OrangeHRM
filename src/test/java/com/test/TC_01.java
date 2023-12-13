package com.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Dashboard_Page;
import com.page_class.Login_Page;
import com.utility.ReadProperties_Utility;
import com.utility.Utility;

public class TC_01 extends Base {

	ReadProperties_Utility read = new ReadProperties_Utility();
	Login_Page login;
	Dashboard_Page dashboard;

	@Test(description = "Verify login with valid ESS username and valid password.")
	public void Test1() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		login = new Login_Page(driver);
		dashboard = new Dashboard_Page(driver);
		
		driver.get(url);
		Thread.sleep(4000);
		login.enterCredLogin();
		login.clickLoginBtn();
		wait.until(ExpectedConditions.visibilityOf(dashboard.DashboardText));
		String expectedText = "Dashboard";
		String actualText = dashboard.DashboardText.getText();
		Assert.assertEquals(expectedText, actualText);

	}

}
