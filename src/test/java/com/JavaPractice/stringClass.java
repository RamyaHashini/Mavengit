package com.JavaPractice;

public class stringClass {

	private static void reverseOFString() {
		String s="reverse";
		for(int i=s.length()-1;i>=0;i--)
		{
			System.out.print(s.charAt(i));
		}
			}
	
	//____________________________________
	private static void reverseOfWord() {
		String s="Automation Testing";
		String[] sp = s.split(" ");
		for(int i=0;i<sp.length;i++)
		{
			String st=sp[i];
			for(int j=st.length()-1;j>=0;j--)
			{
				System.out.print(st.charAt(j));
			}
			System.out.print(" ");
			
		}
		
		//_____________________________________________
		

	}
	private static void vowel() {
		String st="hElloworld";
		String s=st.toLowerCase();
		int count=0;
		for(char c:s.toCharArray())
		{
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			{
				count++;
			}
		}
		System.out.println("no of vowels given string is "+count);
		
		
	}
	//_______________________________________________________
	
	private static void convertCase() {
		String s="hElloworld";
		char[]ch=s.toCharArray();
		for(char c:ch)
			if(Character.isUpperCase(c))
			{
				System.out.print(Character.toLowerCase(c));
			}
			else if(Character.isLowerCase(c))
			{
				System.out.print(Character.toUpperCase(c));
			}

	}
public static	void lowercase()
{
	String s="Automation Testing";
	String st=s.toLowerCase();
	System.out.println(st);
}




	public static void main(String[] args) {
		
		//reverseOFString();
		//reverseOfWord();
		//vowel();
		convertCase();
		//lowercase();
		
	}
}
