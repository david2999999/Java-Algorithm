package Hard.MultiSearch;

import Hard.WordDistance.HashMapList;

import java.util.ArrayList;

public class SolutionWithTrie {

    private HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        Trie trie = createTrieFromString(big);

        for (String s: smalls) {
            ArrayList<Integer> locations = trie.search(s);
            subtractValue(locations, s.length());
            lookup.put(s, locations);
        }

        return lookup;
    }


    private Trie createTrieFromString(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            trie.insertString(suffix, i);
        }
        return trie;
    }

    private void subtractValue(ArrayList<Integer> locations, int delta) {
        if (locations == null) return;
        for (int i = 0; i < locations.size(); i++) {
            locations.set(i, locations.get(i) - delta);
        }
    }
}
