package com.pom;//collection of Webelement
//page object manager is for storing collection of object which is in pom(manager)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;//null
	//pom i.e id for username textbox
	
	@FindBy(id="username")
	private WebElement username;
	
	//pom i.e password for passworbtbx textbox
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement lgbtn;

	public LoginPage(WebDriver driver)
	{
	this.driver=driver; //this.driver means runnerclass driver,simply driver means loginpagedriver,we are assigning here
	PageFactory.initElements(driver, this);//this indicates webElements like lgbtn,username,pwd
	}
//get method for getting value from loginpage to pom(pageObjectManager--> )and to pom(page object manager)
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	

}
