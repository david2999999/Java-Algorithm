public class EightQueens {
    private final int GRID_SIZE = 8;

    public void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (isValidPlacement(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean isValidPlacement(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column1 == column2) {
                return false;
            }

            int columnDistance = Math.max(column1 - column2);
            int rowDistance = row1 - row2;

            if (columnDistance == rowDistance) {
                return false;
            }
        }

        return true;
    }
}