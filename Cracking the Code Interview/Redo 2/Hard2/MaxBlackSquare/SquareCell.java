package Hard2.MaxBlackSquare;

public class SquareCell {
    public int zerosRight = 0;
    public int zerosBelow = 0;

    public SquareCell(int zerosRight, int zerosBelow) {
        this.zerosRight = zerosRight;
        this.zerosBelow = zerosBelow;
    }

    public int getZerosRight() {
        return zerosRight;
    }

    public void setZerosRight(int zerosRight) {
        this.zerosRight = zerosRight;
    }

    public int getZerosBelow() {
        return zerosBelow;
    }

    public void setZerosBelow(int zerosBelow) {
        this.zerosBelow = zerosBelow;
    }
}
