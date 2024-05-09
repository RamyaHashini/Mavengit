package com.testrunner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pom.LoginPage;
import com.sdp.PageObjectManager;


public class MRunnerClass extends BaseClass {
	
	
		
	public static WebDriver driver=BaseClass.browserLaunch("chrome");//null,we hav to initialize here ,else we get null pointer exception

	public static PageObjectManager pom=new PageObjectManager(driver);
	//object creation for loginpage
	//public static LoginPage lp=new LoginPage(driver);//this will create construction in loginpage with parameter as driver,we have to init elementsb there
	
	public static void main(String[] args) throws IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver=browserLaunch("chrome");
				//driver=getUrl("https://adactinhotelapp.com/");
		//driver.get("https://adactinhotelapp.com/");
		getUrl("https://adactinhotelapp.com/");
		
		//WebElement username = driver.findElement(By.id("username"));
		String userdata = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 5, 1);
		inputValueElement(pom.getInstanceLp().getUsername(), userdata);
		
		//WebElement password = driver.findElement(By.id("password"));
		String passdata = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 5, 2);
		inputValueElement(pom.getInstanceLp().getPassword(), passdata);
		
		
		//WebElement login = driver.findElement(By.id("login"));
	
		clickOnElement(pom.getInstanceLp().getLgbtn());
		
		//WebElement location = driver.findElement(By.id("location"));
		dropdown(pom.getInstanceSh().getLocation(),"value" ,"Sydney");
		
		//WebElement roomno = driver.findElement(By.id("room_nos"));
		dropdown(pom.getInstanceSh().getRoomno(), "value", "1");
		
		//WebElement adultperroom = driver.findElement(By.id("adult_room"));
		dropdown(pom.getInstanceSh().getAdultroom(), "value", "3");
		
	//	WebElement search = driver.findElement(By.id("Submit"));
		clickOnElement(pom.getInstanceSh().getSubmitbutton());
	
//		WebElement radiobutton = driver.findElement(By.id("radiobutton_2"));
         clickOnElement(pom.getInstanceSelectHotel().getRadiobutn());
	
		

//		WebElement continue = driver.findElement(By.id("continue"));
    	clickOnElement(pom.getInstanceSelectHotel().getContbutton());
    	
  //book hotel
    	
    	//WebElement firsttname = driver.findElement(By.id("first_name"));
    	//sendKeys("Ramya R");
    	String firstname = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 6, 1);
    	inputValueElement(pom.getInstanceBookHotel().getFirstname(),firstname);
    	
    	//lastname
    	//driver.findElement(By.id("last_name")).sendKeys("ravi");
    	String lastname = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 7, 1);
    	inputValueElement(pom.getInstanceBookHotel().getLastname(),lastname);
    	
    	//address
    	//    	driver.findElement(By.id("address")).sendKeys("Bangalore");
    	String address = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 8, 1);
    	inputValueElement(pom.getInstanceBookHotel().getAdress(),address);
    	
    	//cc number
    	//driver.findElement(By.id("cc_num")).sendKeys("1234567890987654");
    	String ccnumber = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 9, 1);
    	inputValueElement(pom.getInstanceBookHotel().getCreditcardno(),ccnumber);
    	
    	//creditcard type
    	//WebElement credit= driver.findElement(By.id("cc_type"));
    	dropdown(pom.getInstanceBookHotel().getCreditcardtype(), "value", "AMEX");

    	
    	//expiry month
    	dropdown(pom.getInstanceBookHotel().getExpirymonth(), "value", "1");
    	
    	//expiry year
    	dropdown(pom.getInstanceBookHotel().getExpiryyear(), "text", "2026");
    	
    //cvv number	
    	String cvvnumber = readData("C:\\Users\\Hashinipranav\\Desktop\\pro.xlsx", 0, 10, 1);
		inputValueElement(pom.getInstanceBookHotel().getCvvnumber(), cvvnumber);
		
	//booknow button
		clickOnElement(pom.getInstanceBookHotel().getBooknowbtn());
		
//BookingConfirm
		clickOnElement(pom.getInstanceBookingConfirm().getLogout());
		
		screenshot(".\\Screenshot\\evidence.png");
		
		driver=close();
	}
}
