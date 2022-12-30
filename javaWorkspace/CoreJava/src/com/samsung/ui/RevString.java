package com.samsung.ui;
import java.util.*;

public class RevString  
{
	
     static String rev(String s)
     {
    	 String k="";
    	 int l=s.length();
    	 for(int i=l-1;i>=0;--i)
    	 {
    		 char a=s.charAt(i);
    		 k=k+a;
    	 }
    	 
    	 return k;
     }
	
     public static void main(String []args)
     {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("Enter a string");
    	 String s= sc.nextLine();
    	 String k= rev(s);
    	 System.out.println("The reverse is: " + k);
    	 sc.close();
    	 
     }
}