package TreesAndGraphs;

public class FindingCommonAncestorWithoutLinkToParent {
    private TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) return root;

        return ancestorHelp(root, p, q);
    }

    private TreeNode ancestorHelp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnRight = covers(root.right, q);

        if (pIsOnLeft != qIsOnRight) {
            return root;
        }

        TreeNode childSide = pIsOnLeft ? root.left : root.right;

        return ancestorHelp(childSide, p, q);
    }


    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        return covers(root.left, p) || covers(root.right, p);
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
