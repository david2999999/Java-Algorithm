package Hard2.WordRectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class WordGroup {
    private HashMap<String, Boolean> lookup = new HashMap<>();
    private ArrayList<String> group = new ArrayList<>();

    public boolean containsWord(String s) {
        return lookup.containsKey(s);
    }

    public int length() {
        return group.size();
    }

    public String getWord(int i) {
        return group.get(i);
    }

    public ArrayList<String> getWords() {
        return group;
    }

    public void addWord(String s) {
        group.add(s);
        lookup.put(s, true);
    }

    public static WordGroup[] createWordGroup(String[] list) {
        WordGroup[] groupList;
        int maxWordLength = 0;

        // find the maximum word length in the list
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() > maxWordLength) {
                maxWordLength = list[i].length();
            }
        }

        groupList = new WordGroup[maxWordLength];

        for (int i = 0; i < list.length; i++) {
            // the wordLength variable is used as a index since there are no words
            // with a length of 1
            int wordLength = list[i].length() - 1;

            if (groupList[wordLength] == null) {
                groupList[wordLength] = new WordGroup();
            }

            // add the to the wordGroup, all of the words
            // in a list is of the same length
            groupList[wordLength].addWord(list[i]);
        }

        return groupList;
    }
}



















