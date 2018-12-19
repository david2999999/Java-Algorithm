package Hard.LongestWord;

import Hard.WordDistance.HashMapList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LongestWith2Words {

    public String getLongestWord(String[] list) {
        String[] array = list;
        sortByLength(array);

        HashMap<String, Boolean> map = new HashMap<>();

        for (String str: array) {
            map.put(str, true);
        }

        for (String s: array) {
            for (int i = 1; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);

                if ( map.containsKey(left) && map.get(left)
                        && map.containsKey(right) && map.get(right)) {
                    return s;
                }
            }
        }

        return null;
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
