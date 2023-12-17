package com.test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.MyInfo_Page;
import com.reports.ExtentReportListener;
import com.utility.Utility;

@Listeners(ExtentReportListener.class)
public class TC_MyInfo_006 extends Base {

	Login_Page login;
	MyInfo_Page info;

	@Test(description = "Verify ESS user can edit some fileds in Personal Details")
	public void tc_myinfo_006() throws InterruptedException {

		login = new Login_Page(driver);
		info = new MyInfo_Page(driver);
		

		driver.get(url);
		login.enterCredLogin();
		login.clickLoginBtn();
		Utility.clickElement(driver, info.myInfo, 10);
		Utility.sendKeys(driver, info.firstName, "robert", 5, true);
		Utility.sendKeys(driver, info.middleName, "john", 3, true);
		Utility.sendKeys(driver, info.lastName, "smith", 10, true);
		Utility.clickElement(driver, info.save, 10);

	}

}
