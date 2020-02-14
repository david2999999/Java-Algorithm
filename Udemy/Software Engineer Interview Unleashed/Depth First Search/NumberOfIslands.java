public class NumberOfIslands {
    public static int getNumberOfIslands(char[][] grid) {
        int numberOfIslands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 'x') {
                    visitIsland(r, c, grid);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void visitIsland(int r, int c, char[][] grid) {
        if (r >= 0 && r < grid.length &&
            c >= && c < grid[0].length &&
            grid[r][c] == 'x') {
            grid[r][c] = 'm';
            visitIsland(r + 1, c, grid);
            visitIsland(r - 1, c, grid);
            visitIsland(r, c + 1, grid);
            visitIsland(r, c - 1, grid);
        }
    }
}