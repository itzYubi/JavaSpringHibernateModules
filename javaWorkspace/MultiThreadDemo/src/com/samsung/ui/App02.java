package com.samsung.ui;
import java.lang.Thread;
import java.lang.Runnable;

class ThreadCode implements Runnable{
	@Override
	public void run()
	{
		for(int i=0;i<50;++i)
		{
			System.out.print("Child: " + i);
		}
	}
	
}

public class App02 {
   public static void main(String []args)
   {
	   System.out.println("In main()");
	   Thread child= new ChildThread();
	   child.start();
	   System.out.println("In main Again: ");
	   for(int i=0;i<50;++i)
	   {
		   System.out.println("Main => " + i);
	   }
	   System.out.println("End of Main()");
   }
}