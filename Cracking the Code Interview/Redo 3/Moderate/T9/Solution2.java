package Moderate.T9;

import CodeLibrary.Trie;
import CodeLibrary.TrieNode;

import java.util.ArrayList;

public class Solution2 {
    private char[][] t9Letters = {
            null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", trie.getRoot(), results);
        return results;
    }

    private void getValidWords(String number, int index, String prefix,
                               TrieNode trieNode, ArrayList<String> results) {
        if (index == number.length()) {
            if (trieNode.terminates()) {
                results.add(prefix);
            }

            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter: letters) {
                TrieNode child = trieNode.getChild(letter);

                if (child != null) {
                    getValidWords(number, index + 1, prefix + letter, child, results);
                }
            }
        }
    }


    private char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) {
            return null;
        }

        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }
}






















