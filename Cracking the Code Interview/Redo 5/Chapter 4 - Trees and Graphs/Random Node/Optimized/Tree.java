public class Tree {
    private static final Random random = new Random();
    private TreeNode root;

    public int size() {
        return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;

        int randomIndex = random.nextInt(size());
        return root.getIthNode(randomIndex);
    }

    public void insertInOrder(int value) {
        if (root == null) {
            this.root = new TreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }
}