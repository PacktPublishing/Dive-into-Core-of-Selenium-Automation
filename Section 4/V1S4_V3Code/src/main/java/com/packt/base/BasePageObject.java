package com.packt.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageObject {

	protected WebDriver driver;


	public BasePageObject(WebDriver driver) {
		this.driver = driver;
	}


	protected void openUrl(String url) {
		System.out.println("Opening page: " + url);
		driver.get(url);
		System.out.println("Page opened.");
	}


	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}
}
