package Redo.OOD.Othello;

public class Game {
    private static Game instance;
    private Board board;


    public static Game getInstance() {
        if (instance == null) return new Game();

        return instance;
    }

    public Board getBoard() {
        return board;
    }


}
