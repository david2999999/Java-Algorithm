package Hard2.MaxSubmatrix;

public class BruteForce {
    public SubMatrix getMaxMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        // keeps track of the sub matrix with the greatest sum
        SubMatrix best = null;

        for (int row1 = 0; row1 < rowCount; row1++) {
            for (int row2 = row1; row2 < rowCount; row2++) {
                for (int col1 = 0; col1 < columnCount; col1++) {
                    for (int col2 = col1; col2 < columnCount; col2++) {
                        int sum = sum(matrix, row1, col1, row2, col2);

                        // if we find a larger sum
                        if (best == null || best.getSum() < sum) {
                            // update the best submatrix
                            best = new SubMatrix(row1, col1, row2, col2, sum);
                        }
                    }
                }
            }
        }

        // return the best submatrix with the largest sum
        return best;
    }

    private int sum(int[][] matrix, int row1, int col1, int row2, int col2) {
        int sum = 0;
        // loop through the submatrix
        for (int r = row1; r <= row2; r++) {
            for (int c = col1; c <= col2; c++) {
                sum += matrix[r][c];    // update the sum with each cell
            }
        }

        return sum;
    }
}
