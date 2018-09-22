package Redo.Moderate.WordFrequency;

import java.util.HashMap;

public class FrequencyWithHashMap {
    private HashMap<String, Integer> setUpDictionary(String[] word) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String w: word) {
            w = w.toLowerCase();
            if (!w.trim().equals("")) {
                if (!map.containsKey(w)) {
                    map.put(w, 0);
                }

                map.put(w, map.get(w) + 1);
            }
        }

        return map;
    }

    private int getFrequency(HashMap<String, Integer> table, String word) {
        if (table == null || word ==  null) return -1;

        if (table.containsKey(word)) {
            return table.get(word);
        }

        return 0;
    }
}
