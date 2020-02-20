public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;
    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {
        this.pieces = pieces;
        this.size = size;
    }

    private void setEdgeInSolution(LinkedList<Piece> pieces, Edge edge,
                                   int row, int col, Orientation orientation) {
        Piece piece = edge.getParentPiece();
        piece.setEdgeAsOrientation(edge, orientation);
        pieces.remove(piece);
        solution[row][col] = piece;
    }

    private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int col) {}

    public boolean solve() {}
}