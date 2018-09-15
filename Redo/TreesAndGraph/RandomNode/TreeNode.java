package Redo.TreesAndGraph.RandomNode;

import java.util.Random;

public class TreeNode {
    private int data;
    private TreeNode left, right;
    private int size = 0;

    public TreeNode(int data) {
        this.data = data;
        this.size = 1;
    }

    public TreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size;
        Random random = new Random();
        int index = random.nextInt(this.size);

        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int data) {
        if (data <= this.data) {
            if (left == null) {
                left = new TreeNode(data);
            } else {
                left.insertInOrder(data);
            }
        } else {
            if (right == null) {
                right = new TreeNode(data);
            } else {
                right.insertInOrder(data);
            }
        }

        size++;
    }

    public TreeNode getRandomNode(int index) {
        int leftSize = left == null ? 0 : left.getSize();

        if (index < leftSize) {
            return left.getRandomNode(index);
        } else if (index == size) {
            return this;
        } else {
            return right.getRandomNode(index - (leftSize + 1));
        }
    }

    public TreeNode find(int data) {
        if (data == this.data) {
            return this;
        } else if (data <= this.data) {
            return left == null ? null : left.find(data);
        } else {
            return right == null ? null : right.find(data);
        }
    }


    public int getData() {
        return data;
    }

    public int getSize() {
        return size;
    }


}
