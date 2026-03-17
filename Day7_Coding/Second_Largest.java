package Day7_Coding;

public class Second_Largest {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int secondLargest = findSecondLargest(arr);
        System.out.println("The second largest element in the array is: " + secondLargest);
    }

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second largest element in the array");
        }

        return secondLargest;
    }
}
