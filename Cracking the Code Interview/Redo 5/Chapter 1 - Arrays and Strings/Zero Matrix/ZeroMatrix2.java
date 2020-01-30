public class ZeroMatrix2 {
    public void setZeros(int[][] matrix) {
        boolean rowHasZero = checkRowHasZero(matrix);
        boolean colHasZero = checkColHasZero(matrix);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                nullifyRow(matrix, row);
            }
        }

        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                nullifyCol(matrix, col);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        if (colHasZero) {
            nullifyCol(matrix, 0);
        }
    }

    private void nullifyCol(int[][] matrix, int col) {
        for (int row = 1; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int col = 1; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    private boolean checkColHasZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]) {
                return true;
            }
        }
    }

    private boolean checkRowHasZero(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                return true;
            }
        }
    }
}