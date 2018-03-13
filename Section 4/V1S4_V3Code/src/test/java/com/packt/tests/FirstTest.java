package com.packt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.LogInPage;
import com.herokuapp.SecurePage;
import com.packt.base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void firstTest() {
		LogInPage loginPage = new LogInPage(driver);
		loginPage.open();

		SecurePage securePage = loginPage.logIn();
		securePage.waitForSecurePage(10);

		// Verifications
		Assert.assertTrue(securePage.isLogOutButtonVisible(), "LogOut button is not displayed.");
		Assert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"),
				"Page source doesn't contain expected text: 'You logged into a secure area!'");
	}
}
