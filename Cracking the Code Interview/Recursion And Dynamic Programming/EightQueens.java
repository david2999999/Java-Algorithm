package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class EightQueens {
    private int GRID_SIZE = 8;

    private void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column1 == column2) return false;

            int columnDistance = Math.abs(column1 - column2);
            int rowDistance = row2 - row1;

            if (columnDistance == rowDistance) {
                return false;
            }
        }

        return true;
    }
}
