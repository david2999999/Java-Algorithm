package Moderate.LangtonAnt.Grid;

import java.util.Objects;

public class Position{
    public int row;
    public int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position p = (Position) obj;
            return p.row == row && p.col == col;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public Position clone() {
        return new Position(row, col);
    }
}
