package Redo.Moderate.PondSizes;

import java.util.ArrayList;

public class FindSizesWithMemoization {
    private ArrayList<Integer> findPondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                int size = computePondSize(land, visited, r, c);

                if (size > 0) pondSizes.add(size);
            }
        }

        return pondSizes;
    }

    private int computePondSize(int[][] land, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length ||
                col >= land[0].length || visited[row][col] || land[row][col] != 0 ) return 0;

        int size = 1;
        visited[row][col] = true;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computePondSize(land, visited, row + dr, col + dc);
            }
        }

        return size;
    }
}
