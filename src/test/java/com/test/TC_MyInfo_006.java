package com.test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.Base;
import com.page_class.Login_Page;
import com.page_class.MyInfo_Page;
import com.utility.Utility;

public class TC_MyInfo_006 extends Base {

	Login_Page login;
	MyInfo_Page info;

	@Test(description = "Verify ESS user can edit some fileds in Personal Details")
	public void tc_myinfo_006() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		login = new Login_Page(driver);
		info = new MyInfo_Page(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get(url);
		Thread.sleep(3000);

		login.enterCredLogin();
		login.clickLoginBtn();
		
		wait.until(ExpectedConditions.visibilityOf(info.myInfo));
		wait.until(ExpectedConditions.elementToBeClickable(info.myInfo));
		info.clickOnMyinfo();

		wait.until(ExpectedConditions.elementToBeClickable(info.firstName));
		info.firstName.click();
		js.executeScript("arguments[0].value='';", info.firstName);
		info.firstName.sendKeys("india");

		wait.until(ExpectedConditions.visibilityOf(info.middleName));
		info.middleName.click();
		js.executeScript("arguments[0].value='';", info.middleName);
		info.middleName.sendKeys("shrelanka");

		wait.until(ExpectedConditions.visibilityOf(info.lastName));
		info.lastName.click();
		js.executeScript("arguments[0].value='';", info.lastName);
		info.lastName.sendKeys("nepal");

		wait.until(ExpectedConditions.visibilityOf(info.save));
		info.save.click();

//		Utility.clickElement(driver, info.myInfo, 10);
//		Utility.sendKeys(driver, info.firstName, "abc", 10, true);
//		Utility.sendKeys(driver, info.middleName, "xyz", 10, true);
//		Utility.sendKeys(driver, info.lastName, "pqr", 10, true);
//		Utility.clickElement(driver, info.save, 10);
		
		

	}

}
