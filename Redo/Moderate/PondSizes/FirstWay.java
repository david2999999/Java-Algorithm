package Redo.Moderate.PondSizes;

import java.util.ArrayList;

public class FirstWay {
    private ArrayList<Integer> findPondSizes(int[][] land) {
        ArrayList<Integer> pondSizes = new ArrayList<>();

        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[row].length; col++) {
                if (land[row][col] == 0) {
                    int size = calculatePondSize(land, row, col);
                    pondSizes.add(size);
                }
            }
        }

        return pondSizes;
    }

    private int calculatePondSize(int[][] land, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[0].length || land[row][col] != 0) {
            return 0;
        }

        int size = 1;
        land[row][col] = -1;

        for (int rd = -1; rd <= 1; rd++) {
            for (int cd = -1; cd <= 1; cd++) {
                size += calculatePondSize(land, row + rd, col + cd);
            }
        }

        return size;
    }
}
