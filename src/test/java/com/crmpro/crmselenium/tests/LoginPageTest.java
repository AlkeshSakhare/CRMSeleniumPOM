package com.crmpro.crmselenium.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.crmselenium.constants.TestBase;
import com.crmpro.crmselenium.module.LoginModule;

public class LoginPageTest extends TestBase {

	public static LoginModule loginModule;

	@BeforeMethod
	void setUp() {
		init();
		loginModule = new LoginModule();

	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

	@Test
	void verifyLogin() {
		loginModule.doLogin(username, password);
		String title = driver.getTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
}
