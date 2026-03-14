package Day6_coding;

import java.util.Arrays;
import java.util.Scanner;

public class Pythagorean {
     public static boolean triplet(int[] A)
    {
        Arrays.sort(A);
        return (A[0]*A[0] + A[1]*A[1] == A[2]*A[2]);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int [] A= new int[N];
	    for(int i=0;i<N;i++)
	    {
	        A[i] = sc.nextInt();
	    }
	    System.out.println(triplet(A));
	    
	}
}
