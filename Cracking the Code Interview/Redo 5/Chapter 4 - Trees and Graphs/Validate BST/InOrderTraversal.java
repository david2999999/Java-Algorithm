public class InOrderTraversal {
    private int index = 0;

    public boolean isBST(TreeNode node) {
        int[] array = new int[root.size];
        copyBST(node, array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) return false;
        }

        return true;
    }

    public void copyBST(TreeNode node, int[] arr) {
        if (node == null) return;

        copyBST(node.left, arr);
        arr[index++] = node.data;
        copyBST(node.right, arr);
    }
}