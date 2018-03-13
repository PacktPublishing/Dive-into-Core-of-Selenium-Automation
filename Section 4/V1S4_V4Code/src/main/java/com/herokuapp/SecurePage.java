package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.packt.base.BasePageObject;

public class SecurePage extends BasePageObject {

	By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");


	public SecurePage(WebDriver driver) {
		super(driver);
	}


	public void waitForSecurePage(long millis) {
		System.out.println("Waiting for secure page");
		waitForElementPresent(logOutButtonLocator, 10);
	}


	public boolean isLogOutButtonVisible() {
		return find(logOutButtonLocator).isDisplayed();
	}

}
