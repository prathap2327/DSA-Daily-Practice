package Day8_Coding;

import java.util.Scanner;

public class printReverse {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=sc.nextInt();
        }
       printReverse(A);
    }

    public static void printReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
