public class BinarySearchTree {
    private Integer lastValue = null;

    public boolean validBST(TreeNode node) {
        if (node == null) return true;

        if (!validBST(n.left)) return false;

        if (lastValue != null && node.data <= lastValue) {
            return false;
        }

        lastValue = node.data;

        if (!validBST(n.right)) return false;

        return true;
    }
}