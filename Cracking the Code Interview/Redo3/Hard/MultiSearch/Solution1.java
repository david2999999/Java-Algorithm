package Hard.MultiSearch;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

public class Solution1 {
    private HashMapList<String, Integer> searchAll(String big, String[] smalls) {
        HashMapList<String, Integer> lookup = new HashMapList<>();
        for (String small: smalls) {
            ArrayList<Integer> locations = search(big, small);
            lookup.put(small, locations);
        }

        return lookup;
    }

    private ArrayList<Integer> search(String big, String small) {
        ArrayList<Integer> locations = new ArrayList<>();
        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            if (isSubStringAtLocation(big, small, i)) {
                locations.add(i);
            }
        }

        return locations;
    }

    private boolean isSubStringAtLocation(String big, String small, int offset) {
        for (int i = 0; i < small.length(); i++) {
            if (big.charAt(offset + i) != small.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
