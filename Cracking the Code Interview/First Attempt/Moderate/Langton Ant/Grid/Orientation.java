package Moderate.LangtonAnt.Grid;

public enum Orientation {
    left, up, right, down;

    public Orientation getTurn(boolean clockwise) {
        if (this == left) {
            return clockwise ? up : down;
        } else if (this == up) {
            return clockwise ? right : left;
        } else if (this == right) {
            return clockwise ? down : up;
        } else {
            return clockwise ? left : right;
        }
    }
}
