package TreesAndGraphs;

public class SuccessorOfBST {
    public TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;

            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }

            return x;
        }
    }

    public TreeNode leftMostChild(TreeNode n) {
        if (n == null) return null;

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }

    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
