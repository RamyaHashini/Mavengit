package com.sdp;//here we creating single pom object,so it can reduce number of lines

import org.openqa.selenium.WebDriver;

import com.pom.BookHotel;
import com.pom.BookingConfirm;
import com.pom.LoginPage;
import com.pom.SearchHotel;
import com.pom.SelectHotel;

public class PageObjectManager {
	public static WebDriver driver;//null
	 
	//private LoginPage lp;//v hav to keep here all webpages to manage all webelements here
	
	
public PageObjectManager(WebDriver driver2) {
		this.driver=driver2;
	}


public LoginPage getInstanceLp()
{
	LoginPage lp=new LoginPage(driver);
	return lp;
}

public SearchHotel getInstanceSh()
{
	SearchHotel Sh=new SearchHotel(driver);
	return Sh;
	
}

public SelectHotel getInstanceSelectHotel()
{
	SelectHotel selhotel=new SelectHotel(driver);
	return selhotel;
}

public BookHotel getInstanceBookHotel()
{
	BookHotel bukhtl=new BookHotel(driver);
	return bukhtl;
	
}

public BookingConfirm getInstanceBookingConfirm()
{
	BookingConfirm bc=new BookingConfirm(driver);
	return bc;
}
}