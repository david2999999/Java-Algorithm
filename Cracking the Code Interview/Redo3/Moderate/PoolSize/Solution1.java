package Moderate.PoolSize;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Integer> computePondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[r].length; c++) {
                int size = computeSize(land, r, c);
                pondSizes.add(size);
            }
        }

        return pondSizes;
    }

    private int computeSize(int[][] land, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length || land[row][col] != 0) {
            return 0;
        }

        int size = 1;
        land[row][col] = -1;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, row + dr, col + dc);
            }
        }

        return size;
    }
}
