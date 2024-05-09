package com.testng;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class AmazonGetName {
	public static WebDriver driver;
@BeforeSuite
	public void setproperty() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hashinipranav\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
@BeforeClass
	public  void login() 
	{
		driver.get("https://www.amazon.in/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
@Test
private void getText() {
	
	WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
	searchbox.sendKeys("iphone");
	searchbox.submit();
	WebElement element = driver.findElement(By.xpath("(//span[text()='Apple iPhone 15 (128 GB) - Black'])[1]"));
	String text=element.getText();
	System.out.println(text);
	//asset
	String expected=text;
	String actual="Apple iPhone 25 (128 GB) - Black";
	String actual1="Apple iPhone 15 (128 GB) - Black";
//	assertEquals(actual, expected);
//	System.out.println("true");
	
	//SoftAssert
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actual1,expected );
	soft.assertAll();
	System.out.println("done");
	
	
	
	

}
	
	

}


