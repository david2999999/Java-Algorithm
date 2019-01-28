package TreesAndGraph.RandomNode;

public class TreeNode2 {
    private int data;
    public TreeNode2 left;
    public TreeNode2 right;
    private int size = 0;

    public TreeNode2(int data) {
        this.data = data;
        size = 1;
    }

    public TreeNode2 getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size();
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            return right.getIthNode(i - (leftSize + 1));
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode2(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode2(d);
            } else {
                left.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }


}
