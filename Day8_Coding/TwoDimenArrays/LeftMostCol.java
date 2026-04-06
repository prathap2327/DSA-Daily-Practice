package Day8_Coding.TwoDimenArrays;

public class LeftMostCol {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printLeftMostColumn(matrix);
    }

    public static void printLeftMostColumn(int[][] matrix) {
        if (matrix.length == 0) return;

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][0] + " ");
        }
    }
}
