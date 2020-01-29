public class ZeroMatrix {
    public void setZeros(int[][] matrix) {
        if (matrix.length == 0) return;

        boolean[] rows = matrix.length;
        boolean[] columns = matrix[0].length;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < columns.length; j++) {
            if (columns[j]) {
                nullifyColumn(matrix, j);
            }
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}