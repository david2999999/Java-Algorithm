package Moderate.WordFrequency;

import java.util.HashMap;

public class Solution2 {
    private HashMap<String, Integer> setUpDictionary(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();

        for (String word: book) {
            word = word.toLowerCase();

            if (!word.trim().isEmpty()) {
                if (!table.containsKey(word)) {
                    table.put(word, 0);
                }

                table.put(word, table.get(word) + 1);
            }
        }

        return table;
    }

    public int getFrequency(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) return -1;
        word = word.toLowerCase();

        if (table.containsKey(word)) {
            return table.get(word);
        }

        return -1;
    }
}
