package Day7_Coding;

public class AverageofElements {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        double average = calculateAverage(arr);
        System.out.println("The average of the elements in the array is: " + average);
    }

    public static double calculateAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }
}
