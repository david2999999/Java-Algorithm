package Moderate.PondSizes;

import java.util.ArrayList;

public class SolutionWithMemoization {
    private ArrayList<Integer> computePondSizes(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer> sizes = new ArrayList<>();

        for (int r = 0; r < land.length; r++) {
            for (int c = r; c < land[r].length; c++) {
                if (land[r][c] == 0) {
                    int size = computeSize(land, visited, r, c);
                    if (size > 0) {
                        sizes.add(size);
                    }
                }
            }
        }

        return sizes;
    }


    private int computeSize(int[][] land, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length ||
                visited[row][col] || land[row][col] != 0){
            return 0;
        }

        int size = 1;
        visited[row][col] = true;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                size += computeSize(land, visited, row + dr, col + dc);
            }
        }

        return size;
    }
}
