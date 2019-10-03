package Hard2.LongestWord;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// given a list of words, write a program to find the longest word made of other words in the list
public class LongestWord {
    // comparator to sort a string array
    // the array will be sorted in descending order using the length of the strings
    private static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(), o1.length());
        }
    }

    // we will first sort the array in descending order based on the length
    // Then start to find from the longest to shortest string
    public String printLongestWord(String arr[]) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s: arr) {   // put all of the strings into the hashmap with a value of true
            map.put(s, true);
        }

        Arrays.sort(arr, new LengthComparator());   // sort the array descending order by length
        for (String s: arr) {
            if (canBuildWord(s, true, map)) {   // if we can build the word using other words
                System.out.println(s);  // found the word
                return s;   // return the longest word that can be build with other words
            }
        }

        return "";  // did not find the word we want
    }

    private boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String,Boolean> map) {
        // if the map contains the string and also is not the original word
        if (map.containsKey(str) && !isOriginalWord) {
            return map.get(str);    // return true/false based on the string
        }

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);  // left side of the string
            String right = str.substring(i);    // right side of the string

            // if the map contains the left side, and the left side is actually a word (true)
            // and we can build words from the right side of the string
            if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
                return true;    // yes, this word can be built with other words
            }
        }

        map.put(str, false);    // this word can not be built from other words
        return false;   // not the word we want
    }
}












