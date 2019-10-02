package SortingAndSearching;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {
    private void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();

        for (String s: array) {
            String key = sortString(s);
            mapList.put(key, s);
        }

        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t: list) {
                array[index] = t;
                index++;
            }
        }

    }

    private String sortString(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
