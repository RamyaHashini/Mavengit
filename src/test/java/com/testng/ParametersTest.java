package com.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	@Parameters({"username","password"})
	@Test
private void credentials(String username,String password) {
		//inputValueElement(pom.getInstanceLp().getUsername(), userdata);
		System.out.println("username is : "+ username);
		System.out.println("password is : "+ password);
	

}
}
