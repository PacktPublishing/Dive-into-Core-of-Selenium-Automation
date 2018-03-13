package com.packt.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Troubleshooting {

	//@Test
	public void waitTest() {
		// Creating driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		WebElement startButton = driver.findElement(By.xpath("//button"));
		startButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
		
		WebElement finishText = driver.findElement(By.id("finish"));
		Assert.assertTrue(finishText.getText().equals("Hello World!"), "'Hello World! text is not present on the page.'");
		
		driver.quit();
	}
	
	
	//@Test
	public void visibilityTest() {
		// Creating driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		
		WebElement startButton = driver.findElement(By.xpath("//button"));
		System.out.println("Is startButton displayed - " + startButton.isDisplayed());
		startButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		
		WebElement finishText = driver.findElement(By.id("finish"));
		Assert.assertTrue(finishText.getText().equals("Hello World!"), "'Hello World! text is not present on the page.'");
		System.out.println("Is startButton displayed - " + startButton.isDisplayed());
		startButton.click();
		
		driver.quit();
	}
	
	
	@Test
	public void staleElementTest() {
		// Creating driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
		
		WebElement link = driver.findElement(By.linkText("Click here"));
		link.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		
		WebElement message = driver.findElement(By.id("flash"));
		System.out.println("Message: " + message.getText());
		
		link = driver.findElement(By.linkText("Click here"));
		link.click();
		
		message = driver.findElement(By.id("flash"));
		System.out.println("Message: " + message.getText());
		
		driver.quit();
	}

}
