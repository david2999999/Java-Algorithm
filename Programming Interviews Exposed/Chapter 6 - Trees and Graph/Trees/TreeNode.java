public class TreeNode {
    private Node left;
    private Node right;
    private int value;

    public TreeNode( Node left, Node right, int value ){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public int getValue() { return value; }
}
