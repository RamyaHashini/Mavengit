package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//We have to retry the failed test case multiple time i.e 5 times here
//may be it failed due to network issues so we are retry with retestAnalyser
public class RetryClass implements IRetryAnalyzer{
int start=1;
int end=5;
	@Override
	public boolean retry(ITestResult result) {
		
		if(start<=end)
		{
			start++;
			return true;
		}
		return false;
	}

}
