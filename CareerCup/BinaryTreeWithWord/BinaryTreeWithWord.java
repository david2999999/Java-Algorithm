package CareerCup.BinaryTreeWithWord;

import java.util.Arrays;

public class BinaryTreeWithWord {
    public static void main(String[] args) {
        BinaryTreeNode root = generateTreeWithString("epic");
        printTree(root);
    }

    private static void printTree(BinaryTreeNode root) {
        if (root == null) return;

        System.out.println(root.letter);
        printTree(root.left);
        printTree(root.right);
    }

    // since we need to generate a binary search tree with a string
    // we have to sort the string first in an array
    // then our root node will the middle value of the array
    private static BinaryTreeNode generateTreeWithString(String str) {
        if (str == null || str.length() == 0) return null;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return generateTreeWithString(chars, 0, chars.length - 1);
    }

    private static BinaryTreeNode generateTreeWithString(char[] letters, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        BinaryTreeNode newNode = new BinaryTreeNode(letters[mid]);

        newNode.left = generateTreeWithString(letters, start, mid - 1);
        newNode.right = generateTreeWithString(letters, mid + 1, end);

        return newNode;
    }
}
