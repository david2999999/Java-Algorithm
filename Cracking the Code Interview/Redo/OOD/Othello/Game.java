package Redo.OOD.Othello;

public class Game {
    private static Game instance;
    private Board board;
    private Player[] players;
    private final int ROWS = 10;
    private final int COL = 10;

    public Game() {
        board = new Board(ROWS, COL);
        players = new Player[2];
        players[0] = new Player(Color.BLACK);
        players[1] = new Player(Color.WHITE);
    }

    public static Game getInstance() {
        if (instance == null) return new Game();

        return instance;
    }

    public Board getBoard() {
        return board;
    }


}
