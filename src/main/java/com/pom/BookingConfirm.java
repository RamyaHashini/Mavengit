package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirm {
	public static WebDriver driver;//null
	
	@FindBy(id="logout")
	private WebElement logout;
	
	public BookingConfirm(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getLogout() {
		return logout;
	}
	
	
}
