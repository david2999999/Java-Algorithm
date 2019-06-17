package ObjectOrientedDesign.Othello;

public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;

    public Board(int row, int col) {
        this.board = new Piece[row][col];
    }

    public void initialize(){}

    public void placeColor(int row, int col, Color color) {}

    private void flipSection(int row, int col, Color color, Direction d) {}

    public int getColorScore(Color color) {
        if (color == Color.Black) return blackCount;
        else return whiteCount;
    }

    public void updateScore(Color newColor, int newPieces) {}
}
