public class BinaryTree2 {
    public Arraylist<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) current.add(root);

        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for (TreeNode parent: parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }

                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }
}