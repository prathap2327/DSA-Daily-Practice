package Day7_Coding;

public class Largest_In_Array {
      public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int largest = findLargest(arr);
        System.out.println("The largest element in the array is: " + largest);
    }

    public static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
}
}
