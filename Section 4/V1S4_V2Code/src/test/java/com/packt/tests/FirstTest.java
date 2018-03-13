package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.packt.base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void firstTest(){
		// Opening page
		driver.get("http://the-internet.herokuapp.com/login");
		System.out.println("Page opened!");
		
		// LogIn page elements
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		// Typing username and passwords
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		
		// Clicking LogIn button
		loginButton.click();
		
		
		/*
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='button secondary radius']")));
		
		// Verifications
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "LogOut button is not displayed.");
		
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("You logged into a secure area!"), "Page source doesn't contain expected text: 'You logged into a secure area!'");
	}
}
