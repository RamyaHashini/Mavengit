package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//works with retry class
public class AssertClass {

	@Test(retryAnalyzer = RetryClass.class)
private void demo() {
//	//Hard asset
	String expected="James";
	String Actual="Jason";
	Assert.assertEquals(Actual, expected);
	System.out.println("Data validation");
}
	
	
//	@Test
//	private void demo() {
//		//soft asset
//			String expected="James";
//			String Actual="jason";
//			SoftAssert soft=new SoftAssert();
//			soft.assertEquals(Actual, expected);
//			//soft.assertAll();
//			System.out.println("Data v");
//	}
	
}
