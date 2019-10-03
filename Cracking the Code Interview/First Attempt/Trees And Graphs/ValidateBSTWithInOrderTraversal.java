package TreesAndGraphs;

public class ValidateBSTWithInOrderTraversal {
    int index = 0;

    public void copyBST(TreeNode node, int[] array) {
        if (node == null) return;

        copyBST(node.left, array);
        array[index] = node.value;
        index++;

        copyBST(node.right, array);
    }

    public boolean checkBST(TreeNode root) {
        int[] arr = new int[root.size];
        copyBST(root, arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) return false;
        }

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
