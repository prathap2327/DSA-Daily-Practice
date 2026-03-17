package Day7_Coding;

public class Second_Smallest {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int secondSmallest = findSecondSmallest(arr);
        System.out.println("The second smallest element in the array is: " + secondSmallest);
    }

    public static int findSecondSmallest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("There is no second smallest element in the array");
        }

        return secondSmallest;
    }
}
