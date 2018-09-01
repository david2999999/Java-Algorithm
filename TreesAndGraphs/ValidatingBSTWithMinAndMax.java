package TreesAndGraphs;

public class ValidatingBSTWithMinAndMax {
    public boolean checkBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    public boolean checkBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.value <= min) || (max != null && node.value > max)) return false;

        if (!checkBST(node.left, min, node.value) || !checkBST(node.right, node.value, max)) return false;

        return true;
    }


    private class TreeNode {
        public int size;
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
