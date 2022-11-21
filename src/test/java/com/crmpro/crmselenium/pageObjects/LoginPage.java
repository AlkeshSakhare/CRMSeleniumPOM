package com.crmpro.crmselenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.crmselenium.constants.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement usernameTxb;
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwordTxb;
	@FindBy(xpath = "//input[@value='Login']")
	public WebElement loginBtn;
}
