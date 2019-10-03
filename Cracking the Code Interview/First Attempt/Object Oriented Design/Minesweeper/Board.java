package ObjectOrientedDesign.Minesweeper;

public class Board {
    private int nRows;
    private int nCols;
    private int nBombs = 0;
    private Cell[][] cells;
    private Cell[] bombs;
    private int numUnexposedRemaining;

    public Board(int nRows, int nCols, int nBombs) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.cells = new Cell[nRows][nCols];
        this.bombs = new Cell[nBombs];
        numUnexposedRemaining = nRows * nCols;
    }

    public void initializeBoard() {}
    public void flipCell(Cell cell) {}
    public void expandBlack(Cell cell) {}

    public UserPlayResult playFlip(UserPlay userPlay) { return new UserPlayResult(); }
    public int getNumRemaining() {
        return numUnexposedRemaining;
    }
}
