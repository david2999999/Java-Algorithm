package TreesAndGraph;

import CodeLibrary.TreeNode;

public class Successor {
    public TreeNode inOrderSucc(TreeNode n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;

            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }

            return x;
        }
    }

    private TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}
