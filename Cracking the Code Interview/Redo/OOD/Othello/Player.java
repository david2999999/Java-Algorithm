package Redo.OOD.Othello;

public class Player {
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public int getScore() {

        return 1;
    }

    public boolean playPiece(int r, int c) {
        return Game.getInstance().getBoard().placeColor(r, c, color);
    }

    public Color getColor() {
        return color;
    }
}