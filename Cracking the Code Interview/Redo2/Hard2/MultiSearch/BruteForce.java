package Hard2.MultiSearch;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

// given a string b and an array of smaller strings T, design a method to search b for
// each small string in T
public class BruteForce {
    // this example will go through each of the index of string b to look for the smaller string
    public HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        for (String small: smalls) {
            ArrayList<Integer> locations = search(big, small);
            lookup.put(small, locations);   // keep track of the smaller string and all of its locations
        }

        return lookup;  // return all locations of smaller strings
    }

    // find all the locations where the small string appears in the big string
    private ArrayList<Integer> search(String big, String small) {
        ArrayList<Integer> locations = new ArrayList<>();

        // big.length() - small.length() + 1  => no need to search at a specific index if the smaller
        // string does not fit
        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            if (isSubstringAtLocation(big, small, i)) {
                locations.add(i);   // add the location of where we found it
            }
        }

        return locations;   // return all the locations that we found the smaller string
    }

    // checking for the smaller string at a specific index
    private boolean isSubstringAtLocation(String big, String small, int offset) {
        for (int i = 0; i < small.length(); i++) {
            if (big.charAt(offset + i) != small.charAt(i)) {    // characters does not equal
                return false;   // false - invalid comparison, strings does not match
            }
        }

        return true;    // we have found the smaller string inside the big string
    }
}











