package Moderate.TicTacWin;

public class Solution3 {
    public Piece hasWon(Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (hasWinner(board[i][0], board[i][1], board[i][2])) {
                return board[i][0];
            }

            if (hasWinner(board[0][i], board[1][i], board[2][i])) {
                return board[0][i];
            }
        }

        if (hasWinner(board[0][0], board[1][1], board[2][2])) {
            return board[0][0];
        }

        if (hasWinner(board[0][2], board[1][1], board[2][0])) {
            return board[0][2];
        }

        return Piece.Empty;
    }

    private boolean hasWinner(Piece p1, Piece p2, Piece p3) {
        if (p1 == Piece.Empty) {
            return false;
        }

        return p1 == p2 && p2 == p3;
    }
}
