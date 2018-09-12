package Redo;

public class ZeroMatrixOptimized {
    private void setZeroes(int[][] matrix) {
        boolean colHasZero = false;
        boolean rowHasZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                nullifyCol(matrix, i);
        }

        if (colHasZero) {
            nullifyCol(matrix, 0);
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }
    }

    private void nullifyRow(int[][] matrix, int r) {
        for (int c = 0; c < matrix[0].length; c++) {
            matrix[r][c] = 0;
        }
    }

    private void nullifyCol(int[][] matrix, int c) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][c] = 0;
        }
    }
}
