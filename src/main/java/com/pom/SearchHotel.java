package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	
	public static WebDriver driver;//null
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="room_nos")
	private WebElement roomno;
	
	@FindBy(id="adult_room")
	private WebElement adultroom;
	
	@FindBy(id="Submit")
	private WebElement submitbutton;
	
	public SearchHotel(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	//getters ,no setters bcoz in dom we cant write
	public WebElement getLocation() {
		return location;
	}

	public WebElement getRoomno() {
		return roomno;
	}

	public WebElement getAdultroom() {
		return adultroom;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	
	
	
}
