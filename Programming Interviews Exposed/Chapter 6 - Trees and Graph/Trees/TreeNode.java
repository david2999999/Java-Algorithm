public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode( TreeNode left, TreeNode right, int value ){
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }
    public int getValue() { return value; }
}
