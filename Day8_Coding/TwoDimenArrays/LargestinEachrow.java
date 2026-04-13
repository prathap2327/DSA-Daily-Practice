package Day8_Coding.TwoDimenArrays;

public class LargestinEachrow {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        findLargestInRows(arr);
    }

    public static void findLargestInRows(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int largest = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > largest) {
                    largest = array[i][j];
                }
            }
            System.out.println("Largest in row " + i + ": " + largest);
        }
    }
}
