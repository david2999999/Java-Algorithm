public class DepthsOfTree {
    public ArrayList<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> listOfDepths = new ArrayList<>();
        getListOfDepths(root, listOfDepths, 0);
        return root;
    }

    public void getListOfDepths(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        getListOfDepths(root.left, lists, level + 1);
        getListOfDepths(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> getListOfDepthsIterative(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        if (root != null) currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            result.add(currentLevel);

            LinkedList<TreeNode> parents = currentLevel;
            currentLevel = new LinkedList<>();

            for (TreeNode parent: parents) {
                if (parent.left != null) currentLevel.add(parent.left);
                if (parent.right != null) currentLevel.add(parent.right);
            }
        }

        return result;
    }
}