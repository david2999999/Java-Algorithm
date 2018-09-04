package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class RobotInAGrid {
    private ArrayList<Point> findPoints(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) return path;
        else return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        if (row < 0 || col < 0 || !maze[row][col]) return false;

        boolean isAtOrigin = col == 0 && row == 0;

        if (isAtOrigin || getPath(maze, row - 1, col, path) || getPath(maze, row, col - 1, path)) {
            Point point = new Point(row, col);
            path.add(point);
            return true;
        }

        return false;
    }


    private class Point{
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
