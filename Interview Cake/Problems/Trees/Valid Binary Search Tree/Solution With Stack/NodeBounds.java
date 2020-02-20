public class NodeBounds {
    public BinaryTreeNode node;
    public int lowerBound;
    public int upperBound;

    public NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
        this.node = node;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
}