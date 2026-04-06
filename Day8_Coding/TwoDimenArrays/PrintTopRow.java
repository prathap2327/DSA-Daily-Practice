package Day8_Coding.TwoDimenArrays;

public class PrintTopRow {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printTopRow(matrix);
    }

    public static void printTopRow(int[][] matrix) {
        if (matrix.length == 0) return;

        for (int j = 0; j < matrix[0].length; j++) {
            System.out.print(matrix[0][j] + " ");
        }
    }
}
