public class TreeNode {
    private static final class Random random = new Random();
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public TreeNode getRandomNode() {
        int leftTreeSize = this.left == null ? 0 : this.left.size;
        int index = random.nextInt(size);
    }
}