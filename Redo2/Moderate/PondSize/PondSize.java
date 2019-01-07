package Moderate.PondSize;

import java.util.ArrayList;

// given an integer matrix representing a plot of land, where the value of that location represent
// the height above the water. A value of zero indicates water. A pond is a region of water connected
// vertically, horizontally and diagonally. The size of the pond is the total number of connected water cells
// calculate all the sizes of the pond
// Examples:
// Input:
//          0 2 1 0
//          0 1 0 1
//          1 1 0 1
//          0 1 0 1
// Output:
//          2, 4, 1 (any order)
public class PondSize {
    public ArrayList<Integer> computePondSize(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();   // a list to keep track of all the pond sizes

        // loop through the 2D array
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                if (land[r][c] == 0) {  // if the current cell is water
                    int size = computeSize(land, r, c); // compute the pond size of this location
                    pondSizes.add(size);    // add the pond size to the list
                }
            }
        }

        return pondSizes;   // return all of the pond sizes
    }

    private int computeSize(int[][] land, int row, int col) {
        // if the current row and col is index out of bound
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length ||
                land[row][col] != 0) {  // visited or not water
            return 0;   // invalid pond size, size = 0
        }

        int size = 1;   // the size of the current cell
        land[row][col] = -1;    // mark this cell as visited

        // compute the pond size of the cells all around the current cell
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, row + dr, col + dc);
            }
        }

        return size;    // the size of the pond
    }
}














