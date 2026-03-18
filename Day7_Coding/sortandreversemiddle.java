package Day7_Coding;

import java.util.Arrays;

public class sortandreversemiddle {

    // Method to sort the array in ascending order
    public static void sortArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    // Method to reverse the second half of the array
    public static void reverseSecondHalf(int[] A) {
        int mid = A.length / 2;
        int left = mid;
        int right = A.length - 1;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 7, 6, 5, 3};

        // Sort the array
        sortArray(A);

        // Reverse the second half of the array
        reverseSecondHalf(A);

        // Print the final array
        System.out.println(Arrays.toString(A));
    }
}
