package TreesAndGraphs;

public class ValidatingBSTWithoutArrayComparison {
    Integer lastPrinted = null;

    public boolean checkBST(TreeNode root){
        if (root == null) return true;

        if (!checkBST(root.left)) return false;

        if (lastPrinted != null && root.value <= lastPrinted) return false;

        lastPrinted = root.value;

        if (!checkBST(root.right)) return false;

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
