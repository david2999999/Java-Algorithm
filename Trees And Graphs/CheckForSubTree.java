package TreesAndGraphs;

public class CheckForSubTree {

    public boolean containSubTree(TreeNode one, TreeNode two) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(one, string1);
        getOrderString(two, string2);

        return string1.indexOf(string2.toString()) != -1;

    }

    public void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }

        sb.append(node.value + " "); // add the root
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);

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
