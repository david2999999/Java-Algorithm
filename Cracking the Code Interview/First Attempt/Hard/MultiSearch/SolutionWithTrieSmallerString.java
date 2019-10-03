package Hard.MultiSearch;

import Hard.WordDistance.HashMapList;

import java.util.ArrayList;

public class SolutionWithTrieSmallerString {
    HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        int maxLen = big.length();
        TrieNode root = createTreeFromString(smalls, maxLen).getRoot();

        for (int i = 0; i < big.length(); i++) {
            ArrayList<String> strings = findStringsAtLoc(root, big, i);
            for (String s: strings) {
                lookup.put(s, i);
            }
        }

        return lookup;
    }

    private Trie createTreeFromString(String[] smalls, int maxLen) {
        Trie tree = new Trie();
        for (String s: smalls) {
            if (s.length() <= maxLen) {
                tree.insertString(s, 0);
            }
        }

        return tree;
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
}
