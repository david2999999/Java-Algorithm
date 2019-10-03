package CodeLibrary;

import java.util.ArrayList;

public class Trie {
    private TrieNode root;

    public Trie(ArrayList<String> list) {
        root = new TrieNode();
        for (String word: list) {
            root.addWord(word);
        }
    }

    public Trie(String[] list) {
        root = new TrieNode();
        for (String word: list) {
            root.addWord(word);
        }
    }

    public boolean contains(String prefix, boolean exact){
        TrieNode lastNode = root;

        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }

        return !exact || lastNode.terminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }
}
