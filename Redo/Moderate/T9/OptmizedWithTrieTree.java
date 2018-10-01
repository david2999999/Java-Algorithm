package Redo.Moderate.T9;

import CodeLibrary.Trie;
import CodeLibrary.TrieNode;

import java.util.ArrayList;

public class OptmizedWithTrieTree {
    private char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private ArrayList<String> getValidT9Words(String number, Trie trie) {
        ArrayList<String> result = new ArrayList<>();
        getT9Words(number, 0, "", trie.getRoot(), result);
        return result;
    }

    private void getT9Words(String number, int index, String prefix, TrieNode trieNode, ArrayList<String> result) {
        if (index == number.length()) {
            if (trieNode.terminates()) {
                result.add(prefix);
            }

            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Letters(digit);

        if (letters != null) {
            for (char c: letters) {
                TrieNode child = trieNode.getChild(c);

                if (child != null) {
                    getT9Words(number, index + 1, prefix + c, child, result);
                }
            }
        }
    }

    private char[] getT9Letters(int index) {
        if (!Character.isDigit(index)) return null;

        int n = Character.getNumericValue(index) - Character.getNumericValue('0');
        return t9Letters[n];
    }


}
