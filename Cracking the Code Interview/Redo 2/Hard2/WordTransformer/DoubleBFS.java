package Hard2.WordTransformer;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.LinkedList;

public class DoubleBFS {
    public LinkedList<String> transform(String startWord, String stopWord, String[] words) {
        HashMapList<String, String> wildcardToWordList = createWildCardToWordMap(words);

        BFSData sourceData = new BFSData(startWord);
        BFSData destData = new BFSData(stopWord);

        while (!sourceData.isFinished() && !destData.isFinished()) {
            // search a single level from the source node
            String collision = searchLevel(wildcardToWordList, sourceData, destData);

            if (collision != null) {    // if there is a collision at this level
                return mergePaths(sourceData, destData, collision); // merge the two paths at the collision
            }

            // search a single level from the dest node
            collision = searchLevel(wildcardToWordList, destData, sourceData);
            if (collision != null) {    // if there is a collision at this level
                return mergePaths(sourceData, destData, collision); // merge the two paths
            }
        }

        return null;    // there is no path
    }

    private LinkedList<String> mergePaths(BFSData bfs1, BFSData bfs2, String connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);

        LinkedList<String> pathOne = end1.collapse(false);  // the front of the list
        LinkedList<String> pathTwo = end2.collapse(true);   // the end of the list
        pathTwo.removeFirst();  // remove the connection
        pathOne.addAll(pathTwo);    // link the two paths
        return pathOne; // return the list
    }

    // search a single level of the primary node, and check for collision
    private String searchLevel(HashMapList<String,String> wildcardToWordList,
                               BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();

        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            String word = pathNode.getWord();   // get the word from the node

            // check if this node/word has already been visited
            if (secondary.visited.containsKey(word)) {
                return pathNode.getWord();  // return the word
            }

            // get all words that are 1 edit away
            ArrayList<String> words = getValidLinkedWords(word, wildcardToWordList);

            for (String w: words) {
                if (!primary.visited.containsKey(w)) {  // if we have not already visited this node
                    PathNode next = new PathNode(w, pathNode);  // add the current word, with the previous node set to pathNode
                    primary.toVisit.add(next);  // add the node to the queue
                    primary.visited.put(w, next);   // set the node as visited
                }
            }
        }

        return null;    // did not find the collision
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
