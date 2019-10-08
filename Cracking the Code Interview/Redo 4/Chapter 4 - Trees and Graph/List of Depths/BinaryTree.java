public class BinaryTree {
    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int depth) {
        if (root == null) return;

        LinkedList<TreeNode> list = null;

        if (lists.size() == depth) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(depth);
        }

        list.add(root);
        createLevelLinkedList(root.left, lists, depth + 1);
        createLevelLinkedList(root.right, lists, depth + 1);
    }
}