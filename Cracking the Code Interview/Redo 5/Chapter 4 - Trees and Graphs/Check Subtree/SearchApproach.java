public class SearchApproach {
    public boolean isSubtree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        return isSubtreeHelper(node1, node2);
    }

    private boolean isSubtreeHelper(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        } else if (node1.data == node2.data && isMatchingTree(node1, node2)) {
            return true;
        }

        return isSubtreeHelper(node1.left, node2) || isSubtreeHelper(node2.right, node2);
    }

    private boolean isMatchingTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.data != node2.data) {
            return false;
        } else {
            return isMatchingTree(node1.left, node2.left) && isMatchingTree(node1.right, node2.right);
        }
    }
}