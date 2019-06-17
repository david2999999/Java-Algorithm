package Redo.OOD.Othello;

public class Board {
    private Piece[][] board;
    private int blackCount = 0;
    private int whiteCount = 0;

    public Board(int row, int col) {
        this.board = new Piece[row][col];
    }

    public void initialize() {}

    public boolean placeColor(int r, int c, Color color) {
        // check if the index is occupied
        // if it is occupied, return false
        // else place the color inside the board
        // check for rol and col for flips
        return true;
    }

    public int flipSection(int row, int col, Color color, Direction d) {
        return 1;
    }

    public int getScoreFor(Color color) {
        if (color == Color.WHITE) return whiteCount;
        else return blackCount;
    }

    public void updateScore(Color newColor, int newPieces) {
        // update the color score
        // subtract the opposite color
    }
}
