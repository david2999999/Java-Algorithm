package Hard2.MaxBlackSquare;

public class BruteForce {
    public Subsquare findSquare(int[][] matrix) {
        // test all of the square sizes starting from the maximum size
        for (int i = matrix.length; i >= 1; i--) {
            Subsquare square = findSquareWithSize(matrix, i);
            if (square != null) return square;
        }

        return null;
    }

    private Subsquare findSquareWithSize(int[][] matrix, int squareSize) {
        // on an edge of length N, there are (N - squareSize + 1) squares of length squareSize
        int count = matrix.length - squareSize + 1;

        // iterate through all of the squares
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(matrix, row, col, squareSize)) {    // if we found the square
                    return new Subsquare(row, col, squareSize);
                }
            }
        }

        return null;    // did not find the square with the specific square size
    }

    private boolean isSquare(int[][] matrix, int row, int col, int size) {
        // check top and bottom border
        for (int j = 0; j < size; j++) {
            if (matrix[row][col + j] == 1) {    // 1 = white square
                return false;
            }

            if (matrix[row + size - 1][col + j] == 1) {
                return false;
            }
        }

        // check right and left border
        for (int i = 1; i < size; i++) {
            if (matrix[row + i][col] == 1) {
                return false;
            }

            if (matrix[row + i][col + size - 1] == 1) {
                return false;
            }
        }

        return true;
    }
}




















