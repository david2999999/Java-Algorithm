public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;
    
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }
}