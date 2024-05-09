package com.MavenProject;


	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class MavenAdactin {
	public static WebDriver driver;

	public static void browse_launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hashinipranav\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	public static void Launch_url() 
	{
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void Login_credentials()
	{
		driver.findElement(By.id("username")).sendKeys("Jivita04");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
		}

	public static void dropDown()
	{
	WebElement location=driver.findElement(By.id("location"));
	Select s=new Select(location);
	s.selectByVisibleText("Sydney");
	WebElement hotel=driver.findElement(By.id("hotels"));
	Select s1=new Select(hotel);
	s1.selectByValue("Hotel Creek");
	WebElement roomno=driver.findElement(By.id("room_nos"));
	Select s2=new Select(roomno);
	s2.selectByVisibleText("2 - Two");
	}
	public static void normalMethods()
	{
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
	public static void screenshot() throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\\\Users\\\\Hashinipranav\\\\eclipse-workspace\\\\Selenium\\\\Screenshot\\\\ramya1.png");
		FileUtils.copyFile(src, des);
	}

	public static void main(String[] args) throws IOException
	{

		browse_launch();
		Launch_url();
		Login_credentials();
		dropDown();
		normalMethods();
		screenshot();
		driver.findElement(By.id("logout")).click();
		driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();
		//driver.close();
		



	}
		
	}


