package Day5_coding;

import java.util.Scanner;

public class Vote_Eligible {
    public static boolean Age(int N)
    {
        if(N>=18)
        {
            return true;
        }
        return false;
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    if(Age(N))
	    {
		System.out.println("Elligible for Vote");
	    }
	    else
	    {
	        System.out.println("Not Elligible");
	    }
	}
}
