package Redo.RecursionAndDynamicProgramming.PermutationOfString;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationOfDuplicateCharacters {
    private ArrayList<String> findPerms(String str) {
        if (str == null) return null;

        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = frequencyCount(str);
        getPerms(map, "", str.length(), result);
        return result;
    }

    private void getPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c: map.keySet()) {
            int count = map.get(c);
            if (c > 0) {
                map.put(c, count - 1);
                getPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private HashMap<Character, Integer> frequencyCount(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        return map;
    }
}
