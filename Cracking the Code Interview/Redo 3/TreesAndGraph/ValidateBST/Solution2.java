package TreesAndGraph.ValidateBST;

import CodeLibrary.TreeNode;

public class Solution2 {
    private Integer last_printed = null;

    public boolean checkBST(TreeNode n) {
        if (n == null) return true;

        if (!checkBST(n.left)) return false;

        if (last_printed != null && n.data <= last_printed) {
            return false;
        }

        last_printed = n.data;

        if (!checkBST(n.right)) return false;

        return true;
    }
}
