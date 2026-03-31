package Day8_Coding;

public class CheckArraySorted {

    public static boolean isSorted(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        boolean result = isSorted(A);
        if (result) {
            System.out.println("The array is sorted in non-decreasing order.");
        } else {
            System.out.println("The array is not sorted in non-decreasing order.");
        }
    }
}
