package Redo.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {
    private ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> paths = new ArrayList<>();
        HashSet<Point> failPoint = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, paths, failPoint)) {
            return paths;
        } else {
            return null;
        }
    }

    private boolean getPath(boolean[][] maze, int row, int col,
                                     ArrayList<Point> paths, HashSet<Point> failPoints) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        Point point = new Point(row, col);

        if (failPoints.contains(point)) return false;

        boolean isOrigin = col == 0 && row == 0;

        if (isOrigin || getPath(maze, row - 1, col, paths, failPoints)
                || getPath(maze, row, col - 1, paths, failPoints)) {
            paths.add(point);
            return true;
        }

        failPoints.add(point);
        return false;

    }


    private class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
