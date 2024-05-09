package com.testng;

import org.testng.annotations.Test;
//this is for group testing,In this we have 2 groups music and shopping
//we have to run this 2 groups namely music and shopping not this books method
//we have to run in suite file by right click the class and testng-convert to testNg,then it create --.xml file
public class GroupingTest {
	@Test(groups="music")
private void wynk() {
	System.out.println("wynk");

}
	@Test(groups="music")
private void spotify() {
	System.out.println("spotify");

}
	@Test
	private void books() {
		System.out.println("books");

	}
	
	@Test(groups="shopping")
	private void dresses() {
		System.out.println("dresses");
	}
	
	@Test(groups="shopping")
	private void tshirt() {
	System.out.println("tshirt");

	}
}
