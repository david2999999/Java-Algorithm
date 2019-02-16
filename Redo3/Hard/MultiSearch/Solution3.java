package Hard.MultiSearch;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

public class Solution3 {
    private HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        int maxLen = big.length();
        TrieNode root = createTreeFromStrings(smalls, maxLen).getRoot();

        for (int i = 0; i < big.length(); i++) {
            ArrayList<String> strings = findStringsAtLoc(root, big, i);
            insertIntoHashMap(strings, lookup, i);
        }

        return lookup;
    }

    private void insertIntoHashMap(ArrayList<String> strings, HashMapList<String,Integer> lookup, int i) {
        for (String s: strings) {
            lookup.get(s).add(i);
        }
    }

    private ArrayList<String> findStringsAtLoc(TrieNode root, String big, int start) {
        ArrayList<String> strings = new ArrayList<>();
        int index = start;

        while (index < big.length()) {
            root = root.getChild(big.charAt(index));
            if (root == null) break;
            if (root.terminates()) {
                strings.add(big.substring(start, index + 1));
            }

            index++;
        }

        return strings;
    }

    private Trie createTreeFromStrings(String[] smalls, int maxLen) {
        Trie tree = new Trie();
        for (String s: smalls) {
            if (s.length() <= maxLen) {
                tree.insertString(s, 0);
            }
        }

        return tree;
    }
}
