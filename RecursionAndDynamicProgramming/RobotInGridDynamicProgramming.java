package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInGridDynamicProgramming {
    private ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();

        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }

        return null;
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if (row < 0 || col < 0 || !maze[row][col]) return false;

        Point point = new Point(row, col);

        if (failedPoints.contains(point)) return false;

        boolean isAtOrigin = row == 0 || col == 0;

        if (isAtOrigin || getPath(maze, row - 1, col, path, failedPoints) ||
                getPath(maze, row, col - 1 , path, failedPoints)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point);
        return false;
    }
}
