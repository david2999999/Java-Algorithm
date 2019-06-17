package Hard.BabyNames;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    private HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
        HashMap<String, NameSet> groups = constructGroups(names);
        mergeClasses(groups, synonyms);
        return convertToMap(groups);
    }

    private HashMap<String,Integer> convertToMap(HashMap<String,NameSet> groups) {
        HashMap<String, Integer> list = new HashMap<>();
        for (NameSet group: groups.values()) {
            list.put(group.getRootName(), group.getFrequency());
        }

        return list;
    }

    private void mergeClasses(HashMap<String,NameSet> groups, String[][] synonyms) {
        for (String[] entry: synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            NameSet set1 = groups.get(name1);
            NameSet set2 = groups.get(name2);

            if (set1 != set2) {
                NameSet smaller = set2.size() < set1.size() ? set2 : set1;
                NameSet bigger = set2.size() < set1.size() ? set1 : set2;

                Set<String> otherNames = smaller.getNames();
                int frequency = smaller.getFrequency();
                bigger.copyNamesWithFrequency(otherNames, frequency);

                for (String name: otherNames) {
                    groups.put(name, bigger);
                }
            }

        }
    }

    private HashMap<String,NameSet> constructGroups(HashMap<String,Integer> names) {
        HashMap<String, NameSet> groups = new HashMap<>();
        for (Map.Entry<String, Integer> entry: names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            NameSet group = new NameSet(name, frequency);
            groups.put(name, group);
        }

        return groups;
    }
}
