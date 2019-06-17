package Interview;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MissingStringOptimized {
    public static void main(String[] args) {
        System.out.println(findMissingString("This is an example hello world", "is example random"));
    }

    private static String findMissingString(String str1, String str2) {
        if (str1.equals(str2)) return "";
        else if (str1.length() == 0) return str2;
        else if (str2.length() == 0) return str1;

        StringBuilder sb = new StringBuilder();

        String[] string1 = str1.split(" ");
        String[] string2 = str2.split(" ");

        String[] shorter = string1.length < string2.length ? string1 : string2;
        String[] longer = string1.length < string2.length ? string2 : string1;

        LinkedHashMap<String, Integer> table1 = buildStringFrequencyTable(shorter);
        LinkedHashMap<String, Integer> table2 = buildStringFrequencyTable(longer);

        for (String key: table2.keySet()) {
            while (table2.get(key) != 0) {
                if (table1.get(key) == null) {
                    sb.append(key + " ");
                } else {
                    table1.put(key, table1.get(key) - 1);
                }

                table2.put(key, table2.get(key) - 1);
            }
        }

        for (String key: table1.keySet()) {
            while (table1.get(key) != 0) {
                sb.append(key + " ");
                table1.put(key, table1.get(key) - 1);
            }
        }

        return sb.toString();
    }


    private static LinkedHashMap<String, Integer> buildStringFrequencyTable(String[] strings) {
        if (strings.length == 0) return null;

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String str: strings) {
            if (!map.containsKey(str)) {
                map.put(str, 0);
            }

            map.put(str, map.get(str) + 1);
        }

        return map;
    }
}
