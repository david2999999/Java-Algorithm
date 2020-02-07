public class ValidateBST {
    public boolean checkBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    public boolean checkBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }

        if (!checkBST(root.left, min, node.data) || !checkBST(root.right, node.data, max)) {
            return false;
        }

        return true;
    }
}