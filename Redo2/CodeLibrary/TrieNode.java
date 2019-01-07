package CodeLibrary;

import java.util.HashMap;

public class TrieNode {
    // a hashmap for a quick lookup for its children
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false; // a variable to check if this is the last character in a string

    // the character that is stored inside this node
    private char character;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(char character) {
        this(); // initialize the children hashmap
        this.character = character;
    }

    public char getChar() {
        return character;
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) {   // invalid word
            return;
        }

        char firstChar = word.charAt(0);    // first character of the word

        TrieNode child = getChild(firstChar);
        if (child == null) {    // if the child does not exist
            child = new TrieNode(firstChar);    // create a new child
            children.put(firstChar, child); // add the child into the hashmap
        }

        if (word.length() > 1) {    // if the word is longer than 1 character
            child.addWord(word.substring(1));   // add the rest of the string to the child
        } else {
            child.setTerminates(true);  // set the terminate to true, which means the last letter in the string
        }
    }

    public void setTerminates(boolean t) {
        this.terminates = t;
    }

    public boolean terminates() {
        return terminates;
    }

    // get the child with the specific character as data
    public TrieNode getChild(char c) {
        return children.get(c);
    }

}
















