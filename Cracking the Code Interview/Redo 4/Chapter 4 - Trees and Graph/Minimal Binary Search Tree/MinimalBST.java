public class MinimalBST {
    public TreeNode createMinimalBST(int[] sortedArray) {
        return createMinimalBST(sortedArray, 0, sortedArray.length() - 1);
    }

    public TreeNode createMinimalBST(int[] array, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);

        return node;
    }
}