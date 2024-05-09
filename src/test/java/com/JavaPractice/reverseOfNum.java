package com.JavaPractice;

public class reverseOfNum {

	
	public static void main(String[] args) {
		
		int a=123;
	int sum=0;
	while(a>0)
	{
		int rem=a%10;
		sum=(sum*10)+rem;
		a=a/10;
	}
System.out.println(sum);
	}
}
