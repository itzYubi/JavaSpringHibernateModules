package com.samsung.ui;
import java.lang.Thread;

class ChildThread extends Thread{
	@Override
	public void run()
	{
		for(int i=0;i<50;++i)
		{
			System.out.println("Child: " + i);
		}
	}
	
}

public class App01 {
   public static void main(String []args)
   {
	   System.out.println("In main()");
	   ChildThread child= new ChildThread();
	   child.start();
	   System.out.println("In main Again: ");
	   for(int i=0;i<50;++i)
	   {
		   System.out.println("Main => " + i);
	   }
	   System.out.println("End of Main()");
   }
}
