package Day5_coding;

import java.util.Scanner;

public class sumNumbers {
    public static void sumNumbers()
    {
      Scanner sc = new Scanner(System.in);
	    int sum =0;
	    int count = 0;
        double avg = 0;
        int Min = Integer.MAX_VALUE;
        int Max = Integer.MIN_VALUE;
	    while(true)
	    {
	        int N = sc.nextInt();
	        if(N==0)
	        {
	            break;
	        }
	        else 
	        {
	            sum+=N;
                count++;
                if (N < Min) {
                    Min = N;
                }
                if (N > Max) {
                    Max = N;
                }
	        }
	        
	    }
         if (count > 0) { // Only calculate and display average if count > 0
            avg = (double) sum / count;
            System.out.println("Sum: " + sum + ", Count: " + count + ", Average: " + avg);
            System.out.println("Min: " + Min + ", Max: " + Max);
        } else {
            System.out.println("No numbers entered.");
        }
    }
	public static void main(String[] args) {
	    
	    
	    sumNumbers();
	    
	}
}
