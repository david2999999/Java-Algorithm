package Moderate.LangtonAnts.Solution1;

public enum Orientation {
    left, up, right, down;

    public Orientation getTurn(boolean clockWise) {
        if (this == left) {
            return clockWise ? up : down;
        } else if (this == up) {
            return clockWise ? right : left;
        } else if (this == right) {
            return clockWise ? down : up;
        } else {
            return clockWise ? left : right;
        }
    }

    @Override
    public String toString() {
        if (this == left) {
            return "\u2190";
        } else if (this == up) {
            return "\u2191";
        } else if (this == right) {
            return "\u2192";
        } else {
            return "\u2193";
        }
    }
}
