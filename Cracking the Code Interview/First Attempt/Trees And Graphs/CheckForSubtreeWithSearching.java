package TreesAndGraphs;

public class CheckForSubtreeWithSearching {
    private boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;

        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        } else if (r1.value == r2.value && matchTree(r1, r2)) {
            return true;
        }

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    private boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.value != r2.value) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }

    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
