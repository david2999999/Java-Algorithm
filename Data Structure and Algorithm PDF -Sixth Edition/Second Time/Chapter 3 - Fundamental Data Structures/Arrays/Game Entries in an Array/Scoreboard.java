public class ScoredBoard {
    private int numEntries = 0;
    private GameEntry[] board;

    public ScoredBoard(int capacity) {
        this.board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if (numEntries < board.length || newScore > board[numEntries - 1].getScores()) {
            if (numEntries < board.length) numEntries++;

            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            board[j] = e;
        }
    }
}