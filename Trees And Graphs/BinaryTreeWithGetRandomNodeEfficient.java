package TreesAndGraphs;

import java.util.Random;

public class BinaryTreeWithGetRandomNodeEfficient {
    private class Tree {
        TreeNode root = null;

        public int size() {
            return root != null ? root.getSize() : 0;
        }

        public TreeNode getRandomNode() {
            if (root == null) return null;

            int size = this.size();
            Random random = new Random();

            int i = random.nextInt(size);
            return root.getRandomNode(i);
        }

        public void insertInOrder(int data) {
            if (root == null) {
                this.root = new TreeNode(data);
            } else {
                this.root.insertInOrder(data);
            }
        }
    }

    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        private int size;

        public TreeNode(int data) {
            this.data = data;
            this.size = 1;
        }

        public TreeNode getRandomNode(int i) {
            int leftSize = this.left != null ? left.getSize() : 0;

            if (i < leftSize) {
                return this.left.getRandomNode(i);
            } else if (i == leftSize) {
                return this;
            } else {
                return this.right.getRandomNode(i - (leftSize + 1));
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
