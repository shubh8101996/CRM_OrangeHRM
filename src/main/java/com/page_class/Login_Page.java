package com.page_class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.ReadProperties_Utility;
import com.utility.Utility;

public class Login_Page {

	ReadProperties_Utility read;

	WebDriver driver; /// instance

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	public WebElement loginBtn;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterCredLogin() {

		read = new ReadProperties_Utility();
		Utility.sendKeys(driver, username, read.getUsername(), 5, false);
		Utility.sendKeys(driver, password, read.getPassword(), 10, false);

	}

	public void clickLoginBtn() {

		Utility.clickElement(driver, loginBtn, 10);

	}

}
