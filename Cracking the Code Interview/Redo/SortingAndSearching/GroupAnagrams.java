package Redo.SortingAndSearching;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {

    private void anagrams(String[] words) {
        if (words == null) return;

        HashMapList<String, String> hashMapList = new HashMapList<>();

        for (String word: words) {
            String key = sortString(word);
            hashMapList.put(key, word);
        }

        int index = 0;
        for (String key: hashMapList.keySet()) {
            ArrayList<String> list = hashMapList.get(key);

            for (String s: list) {
                words[index] = s;
                index++;
            }
        }
    }

    private String sortString(String str) {
        char[] strChar = str.toCharArray();
        Arrays.sort(strChar);
        return new String(strChar);
    }
}
