public class StringApproach {
    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        StringBuilder tree1 = new StringBuilder();
        StringBuilder tree2 = new StringBuilder();

        buildOrderString(node1, tree1);
        buildOrderString(node2, tree2);

        return tree1.indexOf(tree2.toString()) != -1;
    }

    private void buildOrderString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X");
        }

        sb.append(root.data + " ");
        buildOrderString(root.left, sb);
        buildOrderString(root.right, sb);
    }
}