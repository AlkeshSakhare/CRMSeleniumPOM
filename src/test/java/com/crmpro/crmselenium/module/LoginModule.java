package com.crmpro.crmselenium.module;

import com.crmpro.crmselenium.pageObjects.LoginPage;

public class LoginModule extends LoginPage {

	public LoginModule() {
		super();
	}

	public void doLogin(String un, String pw) {
		usernameTxb.sendKeys(un);
		passwordTxb.sendKeys(pw);
		loginBtn.click();
	}
}
