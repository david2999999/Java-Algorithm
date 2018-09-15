package Redo.TreesAndGraph.RandomNode;

import java.util.Random;

public class Tree {
    private TreeNode root = null;

    public int size() {
        return root == null ? 0 : root.getSize();
    }

    public TreeNode getRandomNode() {
        if (root == null) return null;

        Random random = new Random();
        int index = random.nextInt(root.getSize());
        return root.getRandomNode(index);
    }

    public void insertInOrder(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insertInOrder(data);
        }
    }
}
