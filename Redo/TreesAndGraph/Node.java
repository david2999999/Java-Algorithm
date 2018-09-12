package Redo.TreesAndGraph;

public class Node {
    public RouteBetweenNodes.State state;
    private Node[] adjacents;

    public Node[] getAdjacents() {
        return adjacents;
    }
}
