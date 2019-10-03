package SortingAndSearching;


import CodeLibrary.HashMapList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// write a method to sort an array of string so that all the anagrams
// are next to each other
public class GroupAnagrams {
    // to check if two strings are anagrams
    // we just need to compare the sorted version of the two
    // since the number of character count will be the same

    public void sort(String[] array) {
        // hashmaplist maps a key to an arraylist
        HashMapList<String, String> mapList = new HashMapList<>();

        // grouping words by anagram
        // for example the words {acre, race, care}, if we sort the words
        // the key value of the HashMapList will be acer
        // and the list value will be {acre, race, care}
        // HashMapList = acer -> {acre, race, care}
        for (String s: array) {
            String key = sortChars(s);
            mapList.put(key, s);    // using the sorted string as key
        }

        int index = 0;
        for (String key: mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);  // get the list of anagrams
            for (String t: list) {
                array[index] = t;   // all of the anagrams will be together
                index++;
            }
        }
    }

    // returns a sorted version of the string
    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}














