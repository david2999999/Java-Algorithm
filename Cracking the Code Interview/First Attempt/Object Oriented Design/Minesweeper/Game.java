package ObjectOrientedDesign.Minesweeper;

public class Game {
    public enum GameState{WON ,LOST , RUNNING}

    private int row;
    private int col;
    private int bombs;
    private GameState gameState;
    private Board board;

    public Game(int row, int col, int bombs) {
        this.row = row;
        this.col = col;
        this.bombs = bombs;
        this.board = new Board(col, row, bombs);
        this.gameState = GameState.RUNNING;
    }

    public boolean initialize() { return true; }
    public boolean start() { return true; }
    public boolean playGame() {  return true; } // loops until game is over

}
