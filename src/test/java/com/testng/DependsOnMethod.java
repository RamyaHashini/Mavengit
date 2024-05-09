package com.testng;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test(dependsOnMethods = "browserLaunch")
	private void grtUrl()
{
		System.out.println("grtUrl");

	}
@Test(dependsOnMethods = "setProperty")
	private void browserLaunch() {
	System.out.println("browserLaunch");


	}
@Test(priority = 1)
	private void setProperty() {
		
	System.out.println("setProperty");

	}
@Test(dependsOnMethods = "grtUrl")
	private void login() {
	System.out.println("login");


	}
}
	

