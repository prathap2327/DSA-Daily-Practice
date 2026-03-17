package Day7_Coding;

public class sumofElements {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int sum = calculateSum(arr);
        System.out.println("The sum of the elements in the array is: " + sum);
    }

    public static int calculateSum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
