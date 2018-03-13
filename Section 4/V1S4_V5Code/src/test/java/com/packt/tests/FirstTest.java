package com.packt.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.LogInPage;
import com.herokuapp.SecurePage;
import com.packt.base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void firstTest() {
		SoftAssert softAssert = new SoftAssert();
		LogInPage loginPage = new LogInPage(driver);
		loginPage.open();

		SecurePage securePage = loginPage.logIn();
		securePage.waitForSecurePage(10);

		// Verifications
		softAssert.assertTrue(securePage.isLogOutButtonVisible(), "LogOut button is not displayed.");
		softAssert.assertTrue(securePage.getPageSource().contains("You !logged! into a secure area!"),
				"Page source doesn't contain expected text: 'You logged into a secure area!'");

		softAssert.assertAll();
	}
}
