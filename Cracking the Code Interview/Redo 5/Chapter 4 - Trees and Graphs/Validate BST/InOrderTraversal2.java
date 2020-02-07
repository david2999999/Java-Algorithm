public class InOrderTraversal2 {
    private Integer lastPrinted = null;

    public boolean isValidBST(TreeNode node) {
        if (node == null) return true;

        if (!isValidBST(node.left)) return false;

        if (lastPrinted != null && node.data <= lastPrinted) {
            return false;
        }

        lastPrinted = node.data;

        if (!isValidBST(node.right)) return false;

        return true;
    }
}