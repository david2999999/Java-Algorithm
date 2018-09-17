package Redo.OOD.Othello;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        if (this.color == Color.WHITE) this.color = Color.BLACK;
        else this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }
}
