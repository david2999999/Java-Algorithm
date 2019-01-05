package RecursionAndDynamicProgramming.RobotGrid;

import java.util.ArrayList;

// imagine robot sitting on the bottom right corner of a grid of r rows and c columns
// the robot can move in two directions left and up, but certain cells are off limit such that the
// robot can not step on them
// design an algorithm to find a path for the robot from the bottom right to the top left
public class RobotInGrid {
    // need a private point class to represent a cell in a grid

    public ArrayList<Point> getPath(boolean[][] maze) {
        // there is no maze, return null
        if (maze == null || maze.length == 0) return null;

        // list to store the path
        ArrayList<Point> path = new ArrayList<>();

        // starting from the bottom right corner
        // checking if there is a path
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;    // return the saved path
        }

        return null;    // there is no path
    }

    private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        // index out of bound or the current cell of the maze is not available
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        // boolean to tell if we have reached the top left of the maze
        boolean isAtOrigin = (row == 0) && (col == 0);

        // checking if we are the origin
        // or if there is a path when moving upward, (col - 1) means moving upward
        // or if there is a path when moving left (row - 1) means moving left
        // from the starting position
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            // create a new point
            Point p = new Point(row, col);
            path.add(p);    // add the point to the path
            return true;    // there is a path from the bottom right to the top left
        }

        return false;   // there is no path
    }
}



















