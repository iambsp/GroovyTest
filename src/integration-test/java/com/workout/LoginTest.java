package com.workout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

@Category(IntegrationTest.class)
public class LoginTest {

	static WebDriver driver;
	@Test
	public void TestRun()
	{
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--no-sandbox");
	    WebDriver driver = new ChromeDriver(chromeOptions);
		//FirefoxBinary firefoxBinary = new FirefoxBinary();
		//firefoxBinary.addCommandLineOptions("--headless");
		//System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
		//driver=new FirefoxDriver();
		driver.get("http://localhost:9393/BSP");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("userName")).sendKeys("bsp@demo.com");
		driver.findElement(By.id("userPw")).sendKeys("bsp");
		driver.findElement(By.id("login_btn1")).click();
		//System.out.println(driver.getTitle());
		driver.quit();
	}
	@Test
	public void TestRun1()
	{
	    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--no-sandbox");
	    WebDriver driver = new ChromeDriver(chromeOptions);
		//FirefoxBinary firefoxBinary = new FirefoxBinary();
		//firefoxBinary.addCommandLineOptions("--headless");
		//System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");
		//driver=new FirefoxDriver();
		driver.get("http://localhost:9393/BSP");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("userName")).sendKeys("bsp@demo.com");
		driver.findElement(By.id("userPw")).sendKeys("bsp");
		driver.findElement(By.id("login_btn1")).click();
		//System.out.println(driver.getTitle());
		driver.quit();
	}
}
