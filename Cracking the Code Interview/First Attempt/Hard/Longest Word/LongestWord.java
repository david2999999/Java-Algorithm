package Hard.LongestWord;

import Hard.WordDistance.HashMapList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestWord {
    public String printLongest(String[] arr) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String str: arr) {
            map.put(str, true);
        }

        sortByLength(arr);

        for (String s: arr) {
            if (canBuildWord(s, true, map)) {
                System.out.println(s);
                return s;
            }
        }

        return "";
    }

    private boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginalWord) {
            return map.get(str);
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (map.containsKey(left) && map.get(left) && canBuildWord(right, false, map)) {
                return true;
            }
        }

        map.put(str, false);
        return false;
    }

    private void sortByLength(String[] list) {
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
    }
}
