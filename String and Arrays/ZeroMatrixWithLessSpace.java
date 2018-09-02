package StringAndArrays;

public class ZeroMatrixWithLessSpace {
    public static void main(String[] args) {

    }

    private static void setZeros(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                ZeroMatrix.nullifyCol(matrix, i);
            }
        }

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                ZeroMatrix.nullifyRow(matrix, j);
            }
        }

        if (rowHasZero) {
            ZeroMatrix.nullifyRow(matrix, 0);
        }

        if (colHasZero) {
            ZeroMatrix.nullifyCol(matrix, 0);
        }
    }
}
