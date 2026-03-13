package Day5_coding;

import java.util.Scanner;

public class SumOf_NegEven {
     public static void PosNeg(int[] N)
    {
        int negSum = 0;
        int posEvenSum = 0;
        int posOddSum = 0;
        for (int i = 0; i < N.length; i++) {
            if (N[i] >= 0 && N[i] % 2 != 0) {
                posOddSum += N[i];
            } else if (N[i] >= 0) {
                posEvenSum += N[i];
            } else {
                negSum += N[i];
            }
        }
        System.out.println("Negative Sum: " + negSum);
        System.out.println("Positive Even Sum: " + posEvenSum);
        System.out.println("Positive Odd Sum: " + posOddSum);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size =5;
		int[] N = new int[size]; 
        for (int i = 0; i < size; i++) {
        N[i] = sc.nextInt();
        }
        PosNeg(N);
	}
}
