package Hard2.MaxBlackSquare;

public class Optimized {
    public Subsquare findSquare(int[][] matrix) {
        SquareCell[][] processed = processSquare(matrix);

        for (int i = matrix.length - 1; i >= 1; i--) {
            Subsquare square = findSquareWithSize(processed, i);
            if (square != null) {
                return square;
            }
        }

        return null;
    }

    private Subsquare findSquareWithSize(SquareCell[][] matrix, int squareSize) {
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

    private boolean isSquare(SquareCell[][] matrix, int row, int col, int sz) {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col + sz - 1];
        SquareCell bottomLeft = matrix[row + sz - 1][col];

        // if a border does not contain all black cells
        if (topLeft.zerosRight < sz || topLeft.zerosBelow < sz || topRight.zerosBelow < sz || bottomLeft.zerosRight < sz) {
            return false;
        }

        return true;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;

                // only need to process if it is a black cell
                if (matrix[r][c] == 0) {
                    rightZeros++;
                    belowZeros++;

                    // if there is a column on the right
                    if (c + 1 < matrix.length) {
                        SquareCell previous = processed[r][c + 1];
                        rightZeros += previous.zerosRight;
                    }

                    // if there is a row below
                    if (r + 1 < matrix.length) {
                        SquareCell previous = processed[r + 1][c];
                        belowZeros += previous.zerosBelow;
                    }
                }

                // keeps track of all the zeros to the right and below
                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }

        return processed;
    }

}
