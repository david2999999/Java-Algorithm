public class CommonAncestor {
    public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (!covers(root, node1) || !covers(root, node2)) {
            return null;
        }

        return ancestorHelp(root, node1, node2);
    }

    private TreeNode ancestorHelp(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        boolean node1IsOnLeft = ancestorHelp(root.left, node1);
        boolean node2IsOnLeft = ancestorHelp(root.left, node2);

        if (node1IsOnLeft != node2IsOnLeft) {
            return root;
        }

        TreeNode childNode = node1IsOnLeft ? root.left : root.right;
        return ancestorHelp(childNode, node1, node2);
    }

    private boolean covers(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        } else if (root == target) {
            return true;
        } else {
            return covers(root.left, target) || covers(root.right, target);
        }
    }
}