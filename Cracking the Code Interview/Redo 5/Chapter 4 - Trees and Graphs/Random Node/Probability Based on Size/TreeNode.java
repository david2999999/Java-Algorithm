public class TreeNode {
    private static final Random random = new Random();
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

        if (index < leftTreeSize) {
            return left.getRandomNode();
        } else (index == leftTreeSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }

        size++;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }
}