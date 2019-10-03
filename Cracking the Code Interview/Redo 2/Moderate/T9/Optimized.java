package Moderate.T9;

import CodeLibrary.Trie;
import CodeLibrary.TrieNode;

import java.util.ArrayList;

// On old cell phones, users typed on a numeric keypad and the phone would provide a list of words
// that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an algorithm to return
// a list of matching words, given a sequence of digits.
// 1 ->
// 2 -> abc, 3 -> def, 4 -> ghi
// 5 -> jkl, 6 -> mno, 7 -> pqrs, 8 -> tuv
// 9 -> wxyz
// 0 ->
public class Optimized {
    // number 0 and 1 does not contain any characters
    private char[][] t9Letters = {
            null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    // get the array of letters based on a digit
    private char[] getT9Chars(char digit) {
        // if the input is not a digit
        if (!Character.isDigit(digit)) {
            return null;
        }

        // get the integer representation of the digit to 0 - 9
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }

    // this optimized solution will use the Trie data structure, which is implemented in the last video
    public ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> results = new ArrayList<>();  // a list of all valid words generated from the number
        getValidWords(number, 0, "", trie.getRoot(), results);
        return results; // return all valid words
    }

    private void getValidWords(String number, int index, String prefix,
                               TrieNode trieNode, ArrayList<String> results) {
        if (index == number.length()) { // finished processing the number
            if (trieNode.terminates()) {    // is a complete word
                results.add(prefix);    // add the complete word to the list
            }
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter: letters) {
                TrieNode child = trieNode.getChild(letter); // getting the child of the node using the letter

                // if the child exist
                if (child != null) {
                    // find the remaining word from the trieNode
                    getValidWords(number, index + 1, prefix + letter, child, results);
                }
            }
        }
    }
}
















