package TreesAndGraphs;

import java.util.Random;

public class BinaryTreeWithGetRandomNode {
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        private int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }

        public TreeNode getRandomNode() {
            int leftSize = this.left != null ? left.getSize() : 0;

            Random random = new Random();
            int index = random.nextInt(leftSize);

            if (index < leftSize) {
                return this.left.getRandomNode();
            } else if (index == leftSize) {
                return this;
            } else {
                return this.right.getRandomNode();
            }
        }

        public void insertInOrder(int data) {
            TreeNode node = new TreeNode(data);

            if (data <= this.data) {
                if (left == null) {
                    left = node;
                } else {
                    left.insertInOrder(data);
                }
            } else {
                if (right == null) {
                    right = node;
                } else {
                    right.insertInOrder(data);
                }
            }

            size++;
        }

        public int getSize() {
            return size;
        }

        public TreeNode find(int data) {
            if (data == this.data) {
                return this;
            } else if (data <= this.data) {
                return left != null ? left.find(data) : null;
            } else {
                return right != null ? right.find(data) : null;
            }
        }
    }
}
