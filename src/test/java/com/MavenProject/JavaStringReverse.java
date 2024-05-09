package com.MavenProject;

public class JavaStringReverse {
	public static void main(String[] args) {
		
		String s="Java";
		char ch[]=s.toCharArray();//J a v a
		String reverse="";//[ ]
		
		for(int i=ch.length-1;i>=0;i--)
		{
			reverse=reverse+ch[i];
			
		}
		System.out.println(reverse);
	}

}
//i=4
//i=3,a
//i=2,