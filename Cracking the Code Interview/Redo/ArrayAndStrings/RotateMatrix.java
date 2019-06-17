package Redo.ArrayAndStrings;

public class RotateMatrix {
    private boolean rotateMatrix(int[][] matrix) {
        if (matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        for (int layer = 0; layer < n; layer++) {
            int first = layer;
            int last = n - 1 - first;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return true;
    }
}
