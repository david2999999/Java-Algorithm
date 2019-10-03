package Hard.MultiSearch;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

public class Solution2 {
    private HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        Trie tree = createTrieFromString(big);
        for (String small: smalls) {
            ArrayList<Integer> locations = tree.search(small);
            subtractValue(locations, small.length());
            lookup.put(small, locations);
        }

        return lookup;
    }

    private void subtractValue(ArrayList<Integer> locations, int delta) {
        if (locations == null) return;
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }
    }

    private Trie createTrieFromString(String big) {
        Trie trie = new Trie();
        for (int i = 0; i < big.length(); i++) {
            trie.insertString(big.substring(i), i);
        }

        return trie;
    }
}
