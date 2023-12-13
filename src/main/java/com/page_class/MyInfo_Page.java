package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfo_Page {

	WebDriver driver;

	@FindBy(name = "firstName")
	public WebElement firstName;

	@FindBy(name = "middleName")
	public WebElement middleName;

	@FindBy(name = "lastName")
	public WebElement lastName;

	@FindBy(xpath = "(//button[text()=' Save '])[1]")
	public WebElement save;

	@FindBy(xpath = "//span[text()='My Info']")
	public WebElement myInfo;

	public MyInfo_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyinfo() {

		myInfo.click();

	}

//	public void editDetails() {
//
//		firstName.sendKeys("john");
//		middleName.sendKeys("robert");
//		lastName.sendKeys("smith");
//
//	}
//
//	public void saveDetails() {
//
//		save.click();
//
//	}

}
