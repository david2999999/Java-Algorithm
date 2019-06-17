package TreesAndGraph.CheckSubtree;

import CodeLibrary.TreeNode;

public class Solution1 {
    public boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    private void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('X');
            return;
        }

        sb.append(node.data + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }
}
