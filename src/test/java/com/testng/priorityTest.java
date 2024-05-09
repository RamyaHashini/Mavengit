package com.testng;
//priority starts from -5,-4,-3,-2,-1,0,1,2,3
//if we didint give priority it takes as 0 priority
import org.testng.annotations.Test;

public class priorityTest {
@Test(description="get url",alwaysRun=true)
	private void grtUrl()
{
		System.out.println("grtUrl");

	}
@Test(priority = -1)
	private void browserLaunch() {
	System.out.println("browserLaunch");


	}
@Test(priority = -3)
	private void setProperty() {
		
	System.out.println("setProperty");

	}
@Test(priority = 2,enabled = false)//for ignore we are using enable
	private void login() {
	System.out.println("login");


	}
}
