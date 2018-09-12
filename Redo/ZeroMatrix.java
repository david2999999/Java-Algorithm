package Redo;

public class ZeroMatrix {
    private void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    row[r] = true;
                    col[c] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]) nullifyCol(matrix, i);
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
