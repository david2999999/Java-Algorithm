package Moderate;

public class TicTacToeWinKnowingLastMove {
    private enum Piece {Empty, Red, Blue}

    private Piece hasWon(Piece[][] board, int row, int col) {
        if (board.length != board[0].length) return Piece.Empty;

        Piece piece = board[row][col];

        if (piece == Piece.Empty) return Piece.Empty;

        if (hasWonRow(board, row) || hasWonColumn(board, col)) return piece;

        if (row == col && hasWonDiagonal(board, 1)) {
            return piece;
        }

        if (row == (board.length - col - 1) && hasWonDiagonal(board, -1)) {
            return  piece;
        }

        return Piece.Empty;
    }

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
