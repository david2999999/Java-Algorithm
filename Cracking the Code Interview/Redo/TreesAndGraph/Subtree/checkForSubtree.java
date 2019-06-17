package Redo.TreesAndGraph.Subtree;

import CodeLibrary.TreeNode;

public class checkForSubtree {
    private boolean isSubTree(TreeNode t1, TreeNode t2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        constructStringFromTree(t1, sb1);
        constructStringFromTree(t2, sb2);

        return sb1.indexOf(sb2.toString()) != -1;
    }

    private void constructStringFromTree(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }

        sb.append(node.data + " ");
        constructStringFromTree(node.left, sb);
        constructStringFromTree(node.right, sb);
    }
}
