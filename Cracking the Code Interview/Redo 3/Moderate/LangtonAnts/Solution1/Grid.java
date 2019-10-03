package Moderate.LangtonAnts.Solution1;

public class Grid {
    private boolean[][] grid;
    private Ant ant = new Ant();

    public Grid() {
        grid = new boolean[1][1];
    }

    private void copyWithShift(boolean[][] oldGrid, boolean[][] newGrid, int shiftRow, int shiftColumn) {
        for (int r = 0; r < oldGrid.length; r++) {
            for (int c = 0; c < oldGrid[0].length; c++) {
                newGrid[r + shiftRow][c + shiftColumn] = oldGrid[r][c];
            }
        }
    }

    private void ensureFit(Position position) {
        int shiftRow = 0;
        int shiftColumn = 0;

        int numRows = grid.length;
        if (position.row < 0) {
            shiftRow = numRows;
            numRows *= 2;
        } else if (position.row >= numRows) {
            numRows *= 2;
        }

        int numColumns = grid[0].length;
        if (position.column < 0) {
            shiftColumn = numColumns;
            numColumns *= 2;
        } else if (position.column >= numColumns) {
            numColumns *= 2;
        }

        if (numRows != grid.length || numColumns != grid[0].length) {
            boolean[][] newGrid = new boolean[numRows][numColumns];
            copyWithShift(grid, newGrid, shiftRow, shiftColumn);
            ant.adjustPosition(shiftRow, shiftColumn);
            grid = newGrid;
        }
    }

    private void flip(Position position) {
        int row = position.row;
        int column = position.column;

        grid[row][column] = !grid[row][column];
    }

    public void move() {
        ant.turn(grid[ant.position.row][ant.position.column]);
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (r == ant.position.row && c == ant.position.column) {
                    sb.append(ant.orientation);
                } else if (grid[r][c]) {
                    sb.append("X");
                } else {
                    sb.append("_");
                }
            }

            sb.append("\n");
        }

        sb.append("Ant : " + ant.orientation + ".\n");
        return sb.toString();
    }
}




















