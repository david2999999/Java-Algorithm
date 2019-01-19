package Hard2.WordTransformer;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Optimized {
    LinkedList<String> transform(String start, String stop, String[] words) {
        HashMapList<String, String> wildcardToWordList = createWildCardToWordMap(words);

        // used to prevent recursion on the words that we have already seen
        HashSet<String> visited = new HashSet<>();

        // recursively find the path
        return transform(visited, start, stop, wildcardToWordList);
    }

    private LinkedList<String> transform(HashSet<String> visited, String start,
                                         String stop, HashMapList<String,String> wildcardToWordList) {
        if (start.equals(stop)) {   // we have found a path
            // create a new path
            LinkedList<String> path = new LinkedList<>();
            // add the node to the end of the list
            path.add(start);
            return path;
        } else if (visited.contains(start)) {   // already traversed this path
            return null;
        }

        visited.add(start); // add the current word as visited

        // get all possible words that are 1 edit away
        ArrayList<String> words = getValidLinkedWords(start, wildcardToWordList);

        // for all the words that are one edit away
        for (String word: words) {
            // try to find a path
            LinkedList<String> path = transform(visited, word, stop, wildcardToWordList);

            // if there is a path, add the current word to the front of the path
            if (path != null) {
                path.addFirst(start);
                return path;
            }
        }

        return null;
    }

    private ArrayList<String> getValidLinkedWords(String word, HashMapList<String,String> wildcardToWordList) {
        // get all of the wild cards pertaining to the current word
        ArrayList<String> wildcards = getWildcardRoots(word);
        ArrayList<String> linkedWords = new ArrayList<>();

        for (String wildCard: wildcards) {
            ArrayList<String> words = wildcardToWordList.get(wildCard);

            // add all of the words that are 1 edit away from the current word
            for (String linkedWord: words) {
                if (!linkedWord.equals(word)) {
                    linkedWords.add(linkedWord);
                }
            }
        }

        return linkedWords;
    }

    // linked all of the wildcards to a list of valid words
    private HashMapList<String,String> createWildCardToWordMap(String[] words) {
        HashMapList<String, String> wildcardToWords = new HashMapList<>();
        for (String word: words) {
            // get all possible wildcard pertaining to the current word
            ArrayList<String> linked = getWildcardRoots(word);

            // link all of the wildcards with the current word
            for (String linkedWord: linked) {
                wildcardToWords.put(linkedWord, word);
            }
        }

        return wildcardToWords;
    }

    // get all of the wild cards pertaining to a word
    private ArrayList<String> getWildcardRoots(String w) {
        ArrayList<String> words = new ArrayList<>();

        // add a _ to every position of the word
        for (int i = 0; i < w.length(); i++) {
            String word = w.substring(0, i) + "_" + w.substring(i + 1);
            words.add(word);
        }

        return words;
    }
}
