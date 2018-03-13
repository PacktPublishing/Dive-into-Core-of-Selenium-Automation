package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FirstTest {

	@Test
	public void firstTestMethod() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/login	");
		System.out.println("Page opened");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		driver.quit();
	}

}
