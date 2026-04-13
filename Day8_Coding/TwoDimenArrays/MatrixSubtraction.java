package Day8_Coding.TwoDimenArrays;

public class MatrixSubtraction {
    
    public static void main(String[] args) {
        int[][] matrix1 = {
            {5, 4, 3},
            {2, 1, 0},
            {9, 8, 7}
        };
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] difference = subtractMatrices(matrix1, matrix2);
        printMatrix(difference);
    }

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
