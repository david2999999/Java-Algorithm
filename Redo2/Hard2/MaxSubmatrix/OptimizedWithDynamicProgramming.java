package Hard2.MaxSubmatrix;

public class OptimizedWithDynamicProgramming {
    public SubMatrix getMaxMatrix(int[][] matrix) {
        SubMatrix best = null;
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[][] sumThrough = precomputeSum(matrix);

        for (int row1 = 0; row1 < rowCount; row1++) {
            for (int row2 = row1; row2 < rowCount; row2++) {
                for (int col1 = 0; col1 < colCount; col1++) {
                    for (int col2 = col1; col2 < colCount; col2++) {
                        int sum = sum(sumThrough, row1, col1, row2, col2);

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

    private int sum(int[][] sumThrough, int r1, int c1, int r2, int c2) {
        int topAndLeft = c1 > 0 && r1 > 0 ? sumThrough[r1 - 1][c1 - 1] : 0;
        int left = c1 > 0 ? sumThrough[r2][c1 - 1] : 0;
        int top = r1 > 0 ? sumThrough[r1 - 1][c2] : 0;
        int full = sumThrough[r2][c2];

        // think of the four rectangles
        return full - left - top + topAndLeft;
    }

    private int[][] precomputeSum(int[][] matrix) {
        int[][] sumThrough = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int left = c > 0 ? sumThrough[r][c - 1] : 0;
                int top = r > 0 ? sumThrough[r - 1][c] : 0;
                int overlap = r > 0 && c > 0 ? sumThrough[r - 1][c - 1] : 0;
                sumThrough[r][c] = left + top - overlap + matrix[r][c];
            }
        }

        return sumThrough;
    }
}
