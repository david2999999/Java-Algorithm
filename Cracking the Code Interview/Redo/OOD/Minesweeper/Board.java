package Redo.OOD.Minesweeper;

public class Board {
    private int nRows;
    private int nColumns;
    private int nBombs = 0;
    private Cell[][] cells;
    private Cell[] bombs;
    private int numUnexposedRemaining;

    public Board(int nRows, int nColumns, int nBombs) {
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.nBombs = nBombs;
        this.cells = new Cell[nRows][nColumns];
        this.bombs = new Cell[nBombs];
        this.numUnexposedRemaining = nRows * nColumns - nBombs;
    }

    private void initializeBoard() {}
    private boolean flipCell(Cell cell) {
        return true;
    }

    public void expandBlank(Cell cell) {}
    public UserPlayResult playFlip(UserPlay play) {
        return new UserPlayResult();
    }

    public int getNumUnexposedRemaining() {
        return numUnexposedRemaining;
    }
}
