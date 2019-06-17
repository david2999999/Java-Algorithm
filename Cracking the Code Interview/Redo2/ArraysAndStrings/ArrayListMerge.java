package Redo2.ArraysAndStrings;

import java.util.ArrayList;

public class ArrayListMerge {
    private ArrayList<String> merge(String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<>();
        for (String w: words) sentence.add(w);
        for (String w: more) sentence.add(w);
        return sentence;
    }

}
