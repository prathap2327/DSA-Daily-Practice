package Day6_coding;

import java.util.Scanner;

public class PrimeNumber {
    public static void primeCheck(int N)
    {
        for(int j=1;j<=N;j++)
        {
            if(isPrime(j))
            {
                System.out.println("Number is prime"+j);
            }
        }
    }
    public static boolean isPrime(int j)
    {
        if(j<=1)
        {
            return false;
        }
        
        for(int i=2;i<j;i++)
        {
            if(j%i==0)
            {
                return false;
            }
        }
        return true;
      
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    primeCheck(N);
	    
	}
}
