package com.workout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxOptions;


import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

public class IntTest {
static WebDriver driver;
@Test
public void TestRun()
{
	/*FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver();
        driver = new FirefoxDriver(firefoxOptions);*/

	//driver = new FirefoxDriver(firefoxOptions);
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver= new ChromeDriver(new ChromeDriverService.Builder().usingPort(65530).build());
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    WebDriver driver = new ChromeDriver(chromeOptions);
	driver.get("http://13.233.48.128:9090/WorkOutFinal/");
	System.out.println(driver.getTitle()); //Titel of the webpage
	driver.findElement(By.id("userName")).sendKeys("bsp@demo.com"); //Enter the email
	driver.findElement(By.id("userPw")).sendKeys("bsp"); //Enter the Password 
	driver.findElement(By.id("login_btn1")).click(); //Click login Button
	assertTrue(driver.getPageSource().contains("GOOD THINGS COME TO THOSE WHO SWEAT")); //Check the text in the webpage
	driver.findElement(By.xpath("/html/body/div/div[1]/button")).click(); //select options
	driver.findElement(By.xpath("/html/body/div/div[1]/div/a[1]")).click(); //Select the DropDown Element
	//driver.findElement(By.id("item")).sendKeys("13"); //Enter the Value
	//driver.findElement(By.id("submit")).click();
	assertTrue(driver.getPageSource().contains("Enter the Count to Store")); //Check the Value
	//driver.findElement(By.xpath("/html/body/div[1]/div/button")).click(); //Clear The Screen
	driver.findElement(By.id("submit2")).click(); //Logout
	System.out.println("*************" + driver.getTitle() + "*************"); //Print the Webpage Title
	driver.quit();
}
@Test
public void SignUp()
{
	/*FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver();
        driver = new FirefoxDriver(firefoxOptions);*/
	//driver = new FirefoxDriver(firefoxOptions);
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    WebDriver driver = new ChromeDriver(chromeOptions);
	driver.get("http://13.233.48.128:9090/WorkOutFinal/Signup.jsp?");
	System.out.println(driver.getTitle());
	assertTrue(driver.getPageSource().contains("Workout Tracker"));
	System.out.println("*************" + driver.getTitle() + "*************");
	driver.quit();
}
}
