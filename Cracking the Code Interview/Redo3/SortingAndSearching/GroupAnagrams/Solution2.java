package SortingAndSearching.GroupAnagrams;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    public void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();

        for (String s: array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        int index = 0;
        for (String key: mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t: list) {
                array[index++] = t;
            }
        }
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
