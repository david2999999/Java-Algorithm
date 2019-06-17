package Moderate.LangtonAnt.Grid;

public class Ant {
    public Position position = new Position(0,0);
    public Orientation orientation = Orientation.right;

    public void turn(boolean clockwise) {
        orientation = orientation.getTurn(clockwise);
    }

    public void move() {
        if (orientation == Orientation.left) {
            position.col--;
        } else if (orientation == Orientation.right) {
            position.col++;
        } else if (orientation == Orientation.up) {
            position.row--;
        } else if (orientation == Orientation.down) {
            position.row++;
        }
    }

    public void adjustPosition(int shiftRow, int shiftCol) {
        position.row += shiftRow;
        position.col += shiftCol;
    }
}
