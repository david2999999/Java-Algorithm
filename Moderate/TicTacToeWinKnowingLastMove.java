package Moderate;

public class TicTacToeWinKnowingLastMove {
    private enum Piece {Empty, Red, Blue}

    private boolean hasWonRow(Piece[][] board, int row) {
        for (int c = 1; c < board[row].length; c++) {
            if (board[row][c] != board[row][0]) return false;
        }

        return true;
    }

    private boolean hasWonColumn(Piece[][] board, int col) {
        for (int r = 1; r < board.length; r++) {
            if (board[r][col] != board[0][col]) return false;
        }

        return true;
    }

    private boolean hasWonDiagonal(Piece[][] board, int direction) {
        int row = 0;
        int column = direction == 1 ? 0 : board.length - 1;
        Piece first = board[0][column];

        for (int i = 0; i < board.length; i++) {
            if (board[row][column] != first) {
                return false;
            }

            row += 1;
            column += direction;
        }

        return true;
    }
}
