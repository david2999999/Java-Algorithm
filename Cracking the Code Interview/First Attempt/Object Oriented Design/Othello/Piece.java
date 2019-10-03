package ObjectOrientedDesign.Othello;

public class Piece {
    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public void flip() {
        if (color == Color.Black) color = Color.White;
        else color = Color.Black;
    }

    public Color getColor() {
        return color;
    }
}
