package Redo.OOD.Minesweeper;

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

    public boolean toggleGuess() {
        if (!isExposed) {
            isGuess = !isGuess;
        }

        return isGuess;
    }
}
