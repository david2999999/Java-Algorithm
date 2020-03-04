public class SortedMatrixTopRight {
    public boolean findElement(int[][] matrix, int element) {
        int row = 0;
        int col = matrix.length[0] - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == element) {
                return true;
            } else if (matrix[row][col] > element) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}