package TreesAndGraphs;


public class BSTwithSortedArray {

    public TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private TreeNode createMinimalBST(int array[], int start, int end) {
        if (end < start) return null;

        int middle = (end - start) / 2;

        TreeNode n = new TreeNode(array[middle]);
        n.left = createMinimalBST(array, start, middle - 1);
        n.right = createMinimalBST(array, middle + 1, end);

        return n;
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

