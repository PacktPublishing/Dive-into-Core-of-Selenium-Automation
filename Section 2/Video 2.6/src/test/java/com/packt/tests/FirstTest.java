package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTest {

	@Test
	public void firstTestMethod() {
		// Creating driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Opening page
		driver.get("http://the-internet.herokuapp.com/login	");
		System.out.println("Page opened");
		
		// LogIn page elements
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		// Typing username and passwords
		username.sendKeys("tomsmith");
		password.sendKeys("SuperSecretPassword!");
		
		// Push LogIn button
		login.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verifications
		WebElement logout = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logout.isDisplayed(), "LogOut button is not displayed.");
		
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("You logged into a secure area!"), "Page source does not contain expected text 'You logged into a secure area!'");
		
		driver.quit();
	}

}
