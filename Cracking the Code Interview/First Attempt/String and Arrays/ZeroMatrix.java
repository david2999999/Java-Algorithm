package StringAndArrays;

public class ZeroMatrix {
    public static void main(String[] args) {

    }

    private static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int x = 0; x < row.length; x++) {
            if (row[x]) {
                nullifyRow(matrix, x);
            }
        }

        for (int y = 0; y < col.length; y++) {
            if (col[y]) {
                nullifyCol(matrix, y);
            }
        }
    }

    public static void nullifyCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    public static void nullifyRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }
}
