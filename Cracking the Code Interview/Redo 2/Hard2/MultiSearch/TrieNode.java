package Hard2.MultiSearch;

import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {
    // quick lookup on the children nodes
    private HashMap<Character, TrieNode> children;
    // keeps tracks of the location of the character from the original string
    private ArrayList<Integer> indexes;

    public TrieNode() {
        children = new HashMap<>();
        indexes = new ArrayList<>();
    }

    public void insertString(String s, int index) {
        if (s == null) return;  // invalid string

        indexes.add(index); // add the position of the current character that we are adding
        if (s.length() > 0) {
            char value = s.charAt(0);   // first character from the string
            TrieNode child = null;  // this will be determined soon
            if (children.containsKey(value)) {  // if we already have a child with the character
                child = children.get(value);    // get the child node
            } else {    // do not have a child node with this character
                child = new TrieNode();         // create a new node
                children.put(value, child);     // associate the character with the child node
            }

            String remainder = s.substring(1);  // the rest of the string
            child.insertString(remainder, index + 1);   // recursively add the rest of the string
        } else {    // the string is ""
            children.put('\0', null);   // terminating character
        }
    }

    public ArrayList<Integer> search(String s) {    // search for the string
        if (s == null || s.length() == 0) { // we have reached the end of the string
            return indexes;     // return the current indexes or locations
        } else {
            char first = s.charAt(0);   // first character
            if (children.containsKey(first)) {  // if we have a child that contains the letter
                String remainder = s.substring(1);  // remainder of the string
                // use the child to find the remainder of the string
                return children.get(first).search(remainder);
            }
        }
        return null;    // did not find any location associated with the string
    }

    public boolean terminates() {   // check if the current node is the terminating node
        return children.containsKey('\0');
    }

    public TrieNode getChild(char c) {  // get a child using a character
        return children.get(c);
    }
}













