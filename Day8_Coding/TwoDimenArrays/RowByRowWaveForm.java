package Day8_Coding.TwoDimenArrays;

public class RowByRowWaveForm {
    public static void printWave(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int c = (i % 2 == 0) ? j : (cols - 1 - j);
                System.out.print(matrix[i][c] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        printWave(matrix);
    }
}
