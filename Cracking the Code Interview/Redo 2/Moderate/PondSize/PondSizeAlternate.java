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
public class PondSizeAlternate {
    public ArrayList<Integer> computePondSizes(int[][] land) {
        // a 2D array to keep track of the cells that we have already visited
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer> pondSizes = new ArrayList<>();   // list of all of the pond sizes

        // looping over the whole 2D array
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                int size = computeSize(land, visited, r, c);
                if (size > 0) {
                    pondSizes.add(size);    // add the pond size to the list if it is not 0
                }
            }
        }

        return pondSizes;   // the list of all of the pond sizes
    }

    // compute the pond size of the current cell
    private int computeSize(int[][] land, boolean[][] visited, int row, int col) {
        // if the row or column is index out of bound
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length
                || visited[row][col] || land[row][col] != 0) {  // already visited or the land is not water
            return 0;   // return a pond size of 0
        }

        int size = 1;   // accounting for the current cell
        visited[row][col] = true;   // label the current cell as visited

        // checking all of the surrounding cells
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                // adding the size of the surrounding cells
                size += computeSize(land, visited, row + dr, col + dc);
            }
        }

        return size;    // return the pond size
    }
}


















