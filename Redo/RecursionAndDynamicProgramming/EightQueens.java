package Redo.RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class EightQueens {
    int GRID_SIZE = 8;

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

    private boolean checkValid(Integer[] columns, int row, int col) {
        for (int row2 = 0; row2 < row; row2++) {
            int column2 = columns[row2];

            if (col == column2) return false;

            int colDifference = Math.abs(col - column2);
            int rowDifference = row - row2;

            if (colDifference == rowDifference) return false;
        }

        return true;
    }
}
