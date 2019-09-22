import java.io.*;
import java.util.*;
public class driver 
{
	public static void main(String[] args)
	{
			long startTime;
			long endTime;
			long duration;
			
			try
			{
				PrintWriter expoWriter = new PrintWriter("expoFibOut.txt");
				expoWriter.println("Exponential fibonacci output");
				
				PrintWriter linearWriter = new PrintWriter("linearFibOut.txt");
				linearWriter.println("Linear fibonacci output");
				
				for(int i=5; i <= 40; i=i+5)
				{
					//exponential fib
					startTime = System.currentTimeMillis();
					System.out.println(expoFib(i));
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					expoWriter.println("n= " + i + ": " + duration);
					
					//linear fib
					startTime = System.currentTimeMillis();
					System.out.println(tailFib(i,1,0,0,0));
					endTime = System.currentTimeMillis();
					duration = endTime - startTime;
					linearWriter.println("n= " + i + ": " + duration);
				}
				
				expoWriter.close();
				linearWriter.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Could not open input file for reading.");
				System.exit(0);
			}
			
	}
	
	
	public static int expoFib(int n)
	{
		if(n==0 || n==1 || n==2)
		{
			return 0;
		}
		if(n==3)
		{
			return 1;
		}
		return (expoFib(n-1)+expoFib(n-2)+expoFib(n-3)+expoFib(n-4));
	}
	
	
	static int tailFib(int n, int a, int b, int c, int d)
    {  
          
        if (n == 0 || n==1)
        {
        	return c; 
        }
             
        return tailFib(n-1,b,c,d,a+b+c+d); 
    } 
	
	
}
