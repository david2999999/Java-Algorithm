package Hard2.MultiSearch;

import java.util.ArrayList;

// this is a trie tree, which uses TrieNodes as leafs
public class Trie {
    // the root of the tree
    private TrieNode root = new TrieNode();

    // insert a string into the tree
    public Trie(String s) {
        insertString(s, 0);
    }

    public Trie() { }

    // find a string inside the tree
    // basically find all of the locations the character
    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public void insertString(String str, int location) {
        // insert the string into the root
        root.insertString(str, location);
    }

    // getter for the root
    public TrieNode getRoot() {
        return root;
    }
}










