package Day7_Coding;

public class Smallest_In_Array {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int smallest = findSmallest(arr);
        System.out.println("The smallest element in the array is: " + smallest);
    }

    public static int findSmallest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        return smallest;
    }
}
