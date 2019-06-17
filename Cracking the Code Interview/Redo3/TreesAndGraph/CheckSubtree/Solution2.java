package TreesAndGraph.CheckSubtree;

import CodeLibrary.TreeNode;

public class Solution2 {
    public boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) return false;
        else if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    private boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.data != r2.data) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}
