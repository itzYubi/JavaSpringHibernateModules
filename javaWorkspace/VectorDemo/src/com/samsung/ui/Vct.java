package com.samsung.ui;
import java.util.Vector;

public class Vct {
	 public static void main(String args[]) {   
         Vector<Integer> v = new Vector<Integer>(4);   
         v.add(1);  
         v.add(2);  
         v.add(3);  
         v.add(4);  
         System.out.println("Size is: "+v.size());  
         System.out.println("Default capacity is: "+v.capacity());  
         System.out.println("Vector element is: "+v);  
         v.addElement(5);  
         v.addElement(6);  
         v.addElement(7);  
         System.out.println("Size after addition: "+v.size());  
         System.out.println("Capacity after addition is: "+v.capacity());  
         System.out.println("Elements are: "+v);      
           if(v.contains(2))  
           {  
              System.out.println("2 is present at the index " +v.indexOf(2));  
           }  
           else  
           {  
              System.out.println("2 is not present in the list.");  
           }   
         System.out.println("The first element of the vector is = "+v.firstElement());    
         System.out.println("The last element of the vector is = "+v.lastElement());   
      }  
}
