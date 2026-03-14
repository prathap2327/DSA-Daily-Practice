package Day5_coding;

import java.util.Scanner;

public class Max_Min {
    public static int Min(int A,int B,int C)
    {
        if(A<B&&A<C)
        {
            return A;
        }
        else if(B<C)
        {
            return B;
        }
        else
        {
            return C;
        }
    }
    public static int Max(int A,int B,int C)
    {
        if(A>B&&A>C)
        {
            return A;
        }
        else if(B>C)
        {
            return B;
        }
        else
        {
            return C;
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println(Min(A,B,C));
		System.out.println(Max(A,B,C));
	}
}
