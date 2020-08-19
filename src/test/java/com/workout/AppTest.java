package com.workout;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

	/*@Test
	public void testMain() {
		System.out.println("TestPass1");
	}
*/
	App cal = new App();
	@Test
	public void testAdd()
	{	
		
		int x= 10;
		int y= 12;
		assertEquals(22,cal.add(x,y));
		System.out.println("****************Unit test Successfull****************");
	}

}


/*package com.workout;

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

public class AppTest {
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
	driver.get("http://localhost:5151/WorkOutFinal/");
	System.out.println(driver.getTitle());
	driver.findElement(By.id("userName")).sendKeys("bsp@demo.com");
	driver.findElement(By.id("userPw")).sendKeys("bsp");
	driver.findElement(By.id("login_btn1")).click();
	System.out.println(driver.getTitle());
	driver.quit();
}
}
package com.workout;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

	@Test
	public void testAdd()
	{	
		ArithmeticOperations operations = new ArithmeticOperations();
		Integer actual = operations.add(2, 6);
		Integer expected = 8;
		assertEquals(expected, actual);	
	}

}*/
