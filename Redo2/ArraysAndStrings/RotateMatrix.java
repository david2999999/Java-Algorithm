package ArraysAndStrings;

// given an image represented by N x N matrix
// write a method to rotate the image by 90 degrees
public class RotateMatrix {
    public boolean rotate(int[][] matrix) {
        // if the matrix length is 0
        // OR the matrix row length is not equal to the matrix's column length
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;

        // if the length of the matrix is 4
        // there will be 2 layers
        // ****
        // ****
        // ****
        // ****
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i]; // save top

                matrix[first][i] = matrix[last - offset][first];   // left -> top
                matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left
                matrix[last][last - offset] = matrix[i][last]; // right -> bottom
                matrix[i][last] = top; // saved top -> right
            }
        }

        return true;
    }
}
