package Redo.Moderate.TicTacToe;

public class FindWinWthHashTable {
    public enum Piece {Empty, Red, Blue}

    private int convertBoardToInt(Piece[][] board) {
        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; i++) {
                int value = board[i][j].ordinal();
                sum = sum * 3 + value;
            }
        }

        return sum;
    }
}
