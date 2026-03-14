package Day6_coding;

import java.util.Scanner;

public class SumofNaturalNumbers {
    public static int sumOfNaturalNumbers(int N) {
        if (N <= 0) {
            return 0; // Base case: sum of natural numbers up to 0 is 0
        }
        return N + sumOfNaturalNumbers(N - 1); // Recursive case
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int N = sc.nextInt();
        int sum = sumOfNaturalNumbers(N);
        System.out.println("Sum of natural numbers up to " + N + " is: " + sum);
    }
}
