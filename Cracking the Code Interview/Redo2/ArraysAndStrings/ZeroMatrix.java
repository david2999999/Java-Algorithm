package ArraysAndStrings;

// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
public class ZeroMatrix {
    public void setZeros(int[][] matrix) {
        // 2 arrays to keep track the row and column that has a 0
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // nullify the rows that has a 0
        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // nullify the columns that has a 0
        for (int j = 0; j < column.length; j++) {
            if (column[j]) nullifyColumn(matrix, j);
        }

    }

    // setting the whole column to 0's
    private void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    // setting the whole row to 0's
    private void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
}
