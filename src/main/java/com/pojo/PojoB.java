package com.pojo;

public class PojoB {
	public static void main(String[] args) {
		PojoA a=new PojoA();
		String name=a.getName();
		System.out.println("Before setters: "+name );
		a.setName("james");
		String name2 = a.getName();
		System.out.println("After setters: "+name2 );
		
	}

}
