package Moderate.TicTacWin;

public class Solution1 {
    public int convertBoardToSum(Piece[][] board) {
        int sum = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int value = board[i][j].ordinal();
                sum = sum * 3 + value;
            }
        }

        return sum;
    }
}
