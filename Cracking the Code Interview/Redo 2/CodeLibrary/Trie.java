package CodeLibrary;

import java.util.ArrayList;

public class Trie {
    // the root of the trie tree
    private TrieNode root;

    // initialize the tree with a list of words
    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word: list) {
            root.addWord(word);
        }
    }

    // initialize the tree with an array of words
    public Trie(String[] list) {
        root = new TrieNode();
        for (String word: list) {
            root.addWord(word);
        }
    }

    // check if a word or prefix is contained in a tree
    // the boolean variable exact checks if it is a exact string or a substring
    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        int i = 0;

        // loop through the string, and check for individual characters in the tree
        for (i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }

        // check if it is the exact word, by checking if the node terminates
        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }
}
















