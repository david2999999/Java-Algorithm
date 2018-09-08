package Moderate;

public class TicTacToeNxNBoard {
    private enum Piece {Empty, Red, Blue}

    private Piece hasWon(Piece[][] board) {
        int size = board.length;
        if (size != board[0].length) return Piece.Empty;
        Piece first;

        for (int i = 0; i < size; i++) {
            first = board[i][0];

            if (first == Piece.Empty) continue;

            for (int j = 1; j < size; j++) {
                if (first != board[i][j]) {
                    return Piece.Empty;
                } else if (j == size - 1) {
                    return first;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            first = board[0][i];

            if (first == Piece.Empty) continue;

            for (int j = 1; j < size; j++) {
                if (first != board[j][i]) {
                    return Piece.Empty;
                } else if (j == size - 1) return first;
            }
        }

        first = board[0][0];
        if (first != Piece.Empty) {
            for (int i = 0; i < size; i++) {
                if (first != board[i][i]) return Piece.Empty;
                else if (i == size - 1) return  first;
            }
        }

        first = board[0][size - 1];
        if (first != Piece.Empty) {
            for (int i = 1; i < size; i++) {
                if (board[i][size - i - 1] != first) {
                    return Piece.Empty;
                } else if (i == size - 1) return first;
            }
        }

        return Piece.Empty;
    }
}
