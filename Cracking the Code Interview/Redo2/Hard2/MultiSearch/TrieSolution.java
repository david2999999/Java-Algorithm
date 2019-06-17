package Hard2.MultiSearch;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

// given a string b and an array of smaller strings T, design a method to search b for
// each small string in T
public class TrieSolution {
    // in this solution, we will use the trie tree to find all of the positions of the smaller strings

    public HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        // store all locations of the small strings
        HashMapList<String, Integer> lookup = new HashMapList<>();

        // create a trie tree with the large string
        Trie tree = createTrieFromString(big);

        for (String s: smalls) {    // finding all locations of the small strings
            ArrayList<Integer> locations = tree.search(s);  // all locations of this string

            // adjust to starting location, because when we search for a small string
            // we end up at the end of the small string
            // we want to find the starting position of the small string
            subtractValue(locations, s.length());

            // put the smaller string and all of its associated positions inside the bigger string
            lookup.put(s, locations);
        }

        return lookup;  // all positions of the smaller string inside the big string
    }

    // locations = all locations which are the last character of the smaller string
    // delta = length of the smaller string
    // last position - length of the string = first position or first character
    private void subtractValue(ArrayList<Integer> locations, int delta) {
        if (locations == null) return;  // invalid locations
        for (int i = 0; i < locations.size(); i++) {
            // update the location to the starting position of the smaller string
            locations.set(i, locations.get(i) - delta);
        }
    }

    private Trie createTrieFromString(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            // insert all of the substrings at each index into the tree
            // for example: if the s is abcd
            // insert the strings, abcd, bcd, cd, d
            trie.insertString(suffix, i);
        }

        return trie;
    }


}
