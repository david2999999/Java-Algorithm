package Moderate.LangtonAnt.Hashset;

import Moderate.LangtonAnt.Grid.Ant;
import Moderate.LangtonAnt.Grid.Position;

import java.util.HashSet;

public class Board {
    private HashSet<Position> white = new HashSet<>();
    private Ant ant = new Ant();
    private Position topLeftCorner = new Position(0,0);
    private Position bottomRightCorner = new Position(0, 0);

    public Board() {}

    public void move() {
        ant.turn(isWhite(ant.position));
        flip(ant.position);
        ant.move();
        ensureFit(ant.position);
    }

    private void ensureFit(Position p) {
        int row = p.row;
        int col = p.col;

        topLeftCorner.row = Math.min(topLeftCorner.row, row);
        topLeftCorner.col = Math.min(topLeftCorner.col, col);

        bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
        bottomRightCorner.col = Math.max(bottomRightCorner.col, col);
    }

    private void flip(Position p) {
        if (white.contains(p)){
            white.remove(p);
        } else {
            white.add(p.clone());
        }
    }

    public boolean isWhite(Position p) {
        return white.contains(p);
    }

    public boolean isWhite(int row, int col) {
        return white.contains(new Position(row, col));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowMin = topLeftCorner.row;
        int rowMax = bottomRightCorner.row;
        int colMin = topLeftCorner.col;
        int colMax = bottomRightCorner.col;

        for (int r = rowMin; r <= rowMax; r++) {
            for (int c = colMin; c <= colMax; c++) {
                if (r == ant.position.row && c == ant.position.col) {
                    sb.append(ant.orientation);
                } else if (isWhite(r, c)) {
                    sb.append("X");
                } else {
                    sb.append("_");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
