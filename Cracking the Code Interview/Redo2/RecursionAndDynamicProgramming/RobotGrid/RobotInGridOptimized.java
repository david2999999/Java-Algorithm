package RecursionAndDynamicProgramming.RobotGrid;

import java.util.ArrayList;
import java.util.HashSet;

// imagine robot sitting on the bottom right corner of a grid of r rows and c columns
// the robot can move in two directions left and up, but certain cells are off limit such that the
// robot can not step on them
// design an algorithm to find a path for the robot from the bottom right to the top left
public class RobotInGridOptimized {
    // the Point class is in the previous video

    public ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) { // if the maze is invalid
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();  // a list to store all valid points in the path
        HashSet<Point> failedPoints = new HashSet<>();  // stores cells that we have already traversed

        // checking if there is a path from the bottom right
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;    // return the saved path, if there is a path from bottom right to top left
        }

        return null;    // there is no path
    }

    // this example uses memoization to check if we have already recurse down a path
    private boolean getPath(boolean[][] maze, int row, int col,
                            ArrayList<Point> path, HashSet<Point> failedPoints) {
        // if there is an index out of bound
        // or if the current cell of the maze is unavailable
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);  // storing the current point

        // we have already visited this cell
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);  // checking if we have reached the upper left corner

        // there is a path from the start to this current location
        if (isAtOrigin || getPath(maze, row, col -1, path, failedPoints) ||
                getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);    // add the point to the path
            return true;    // there is a path
        }

        failedPoints.add(p);    // cached the failed points, so we do not traverse this point again
        return false;   // there is no path to this point
    }
}
















