package Day8_Coding.TwoDimenArrays;

public class ColWaveform {
    public static void printWave(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int r = (j % 2 == 0) ? i : (rows - 1 - i);
                System.out.print(matrix[r][j] + " ");
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
