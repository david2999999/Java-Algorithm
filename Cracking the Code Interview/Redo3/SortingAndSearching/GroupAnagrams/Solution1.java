package SortingAndSearching.GroupAnagrams;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
    private static class AnagramComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }

        private String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }
    }
}
