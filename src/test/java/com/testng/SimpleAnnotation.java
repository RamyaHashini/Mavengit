package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAnnotation {
public static WebDriver driver;
	@BeforeSuite
	private void setProperty() {
		System.out.println("setProperty");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hashinipranav\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
//		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
	}
	
	@BeforeTest
	private void browserLaunch() {
		System.out.println("browserLaunch");
		driver=new ChromeDriver();

	}
	
	@BeforeClass
	private void getUrl() {
		System.out.println("getUrl");
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}
	
	@BeforeMethod
	private void signIn() {
		System.out.println("signIn");

		driver.findElement(By.id("username")).sendKeys("Jivita04");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();

	}
	@Ignore
	@Test
	private void Adactin() {
		System.out.println("Adactin");
		WebElement location=driver.findElement(By.id("location"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		WebElement hotel=driver.findElement(By.id("hotels"));
		Select s1=new Select(hotel);
		s1.selectByValue("Hotel Creek");
		WebElement roomno=driver.findElement(By.id("room_nos"));
		Select s2=new Select(roomno);
		s2.selectByVisibleText("2 - Two");
		driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys("03/04/2024");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_1")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys("Ramya R");
		driver.findElement(By.id("last_name")).sendKeys("ravi");
		driver.findElement(By.id("address")).sendKeys("Bangalore");
		driver.findElement(By.id("cc_num")).sendKeys("1234567890987654");
		WebElement credit= driver.findElement(By.id("cc_type"));
		Select s3=new Select(credit);
		s3.selectByValue("AMEX");
		WebElement expmonth= driver.findElement(By.id("cc_exp_month"));
		Select s4=new Select(expmonth);
		s4.selectByVisibleText("February");
		WebElement expyear=driver.findElement(By.id("cc_exp_year"));
		Select s5=new Select(expyear);
		s5.selectByVisibleText("2029");
		driver.findElement(By.id("cc_cvv")).sendKeys("747");
		driver.findElement(By.id("book_now")).click();
		driver.findElement(By.id("my_itinerary")).click();
		}
//1
	
	@Test(priority = 0)
	private void searchHotel() {
		System.out.println("searchHotel page");
		WebElement location=driver.findElement(By.id("location"));
		Select s=new Select(location);
		s.selectByVisibleText("Sydney");
		WebElement hotel=driver.findElement(By.id("hotels"));
		Select s1=new Select(hotel);
		s1.selectByValue("Hotel Creek");
		WebElement roomno=driver.findElement(By.id("room_nos"));
		Select s2=new Select(roomno);
		s2.selectByVisibleText("2 - Two");
		driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys("03/04/2024");
		driver.findElement(By.id("Submit")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		//2
	//@Test(dependsOnMethods = "searchHotel")
	@Test(priority = 1)
	private void selectHotel()  {
	
	System.out.println("selectHotel");
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.findElement(By.id("radiobutton_1")).click();
		
		driver.findElement(By.id("continue")).click();
		
	}
//3
	@Test(priority = 3)
//@Test(dependsOnMethods = "selectHotel")
private void bookHotel() {
	System.out.println("bookHotel");
	driver.findElement(By.id("first_name")).sendKeys("Ramya R");
	driver.findElement(By.id("last_name")).sendKeys("ravi");
	driver.findElement(By.id("address")).sendKeys("Bangalore");
	driver.findElement(By.id("cc_num")).sendKeys("1234567890987654");
	WebElement credit= driver.findElement(By.id("cc_type"));
	Select s3=new Select(credit);
	s3.selectByValue("AMEX");
	WebElement expmonth= driver.findElement(By.id("cc_exp_month"));
	Select s4=new Select(expmonth);
	s4.selectByVisibleText("February");
	WebElement expyear=driver.findElement(By.id("cc_exp_year"));
	Select s5=new Select(expyear);
	s5.selectByVisibleText("2029");
	driver.findElement(By.id("cc_cvv")).sendKeys("747");
	driver.findElement(By.id("book_now")).click();	
}
//4
	@Test(priority = 4)
//@Test(dependsOnMethods ="bookHotel")
private void bookingConfirm() {
	System.out.println("bookingConfirm");
	driver.findElement(By.id("my_itinerary")).click();
	
}

	
	@Test(priority = 4)
	
	private void signOff() {
		System.out.println("Adactin");
		driver.findElement(By.id("logout")).click();
	}
	
//	@Ignore
//	@AfterClass
//	private void homePageValidation() {
//		
//		System.out.println("homePageValidation");
//	}
//	
//	@Ignore
//	@AfterTest
//	private void close() {
//		System.out.println("close");
//		driver.close();
//	}
//	@Ignore
//	@AfterSuite
//	private void deleteAllCookies() {
//		System.out.println("deleteAllCookies");
//		
//     driver.manage().deleteAllCookies();
//	}
}
