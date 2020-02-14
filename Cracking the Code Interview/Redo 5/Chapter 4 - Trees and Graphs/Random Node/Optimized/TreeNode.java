public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public TreeNode getIthNode(int index) {
        int leftTreeSize = this.left == null ? 0 : this.left.size;

        if (index < leftTreeSize) {
            return left.getIthNode(index);
        } else (index == leftTreeSize) {
            return this;
        } else {
            return right.getIthNode(index - (leftTreeSize + 1));
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