package ObjectOrientedDesign.Minesweeper;

public class Cell {
    private int row;
    private int col;
    private boolean isBomb;
    private int number;
    private boolean isExposed = false;
    private boolean isGuess = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public boolean flip() {
        isExposed = true;
        return !isBomb;
    }

    public boolean toggleguess() {
        if (!isExposed) {
            isGuess = !isGuess;
        }

        return isGuess;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public boolean isGuess() {
        return isGuess;
    }

    public void setGuess(boolean guess) {
        isGuess = guess;
    }
}
