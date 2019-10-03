package Hard2.SparseSimilarity;

import CodeLibrary.HashMapList;

import java.util.*;

public class Optimized {
    public HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents) {
        HashMapList<Integer, Integer> wordToDocs = groupWords(documents);
        HashMap<DocPair, Double> similarities = computeIntersections(wordToDocs);
        // now we have gotten all of the similarity count, we want to adjust it
        // to percentage of the overall union
        adjustSimilarities(documents, similarities);

        return similarities;
    }

    private void adjustSimilarities(HashMap<Integer,Document> documents, HashMap<DocPair,Double> similarities) {
        // get all pairs of documents and their intersection count
        for (Map.Entry<DocPair, Double> entry: similarities.entrySet()) {
            DocPair pair = entry.getKey();  // get a pair
            Double intersection = entry.getValue(); // intersection count
            Document doc1 = documents.get(pair.doc1);   // get 1st document
            Document doc2 = documents.get(pair.doc2);   // get 2nd document

            // calculate the union between the two docs
            double union = (double) doc1.size() + (double) doc2.size() - intersection;

            // set the new value (intersection / total).
            entry.setValue(intersection / union);
        }
    }

    private HashMap<DocPair,Double> computeIntersections(HashMapList<Integer,Integer> wordToDocs) {
        HashMap<DocPair, Double> similarities = new HashMap<>();
        Set<Integer> words = wordToDocs.keySet();   // get all of the words

        for (int word: words) {
            // get all of the documents that has this word
            ArrayList<Integer> docs = wordToDocs.get(word);
            Collections.sort(docs); // sort the documents
            for (int i = 0; i < docs.size(); i++) {
                for (int j = i + 1; j < docs.size(); j++) {
                    // increment the similarities of the documents
                    increment(similarities, docs.get(i), docs.get(j));
                }
            }
        }

        return similarities;
    }

    private void increment(HashMap<DocPair,Double> similarities, Integer doc1, Integer doc2) {
        DocPair pair = new DocPair(doc1, doc2);
        if (!similarities.containsKey(pair)) {  // if the pair has not been in the hashmap yet
            // set the similarity number to 1
            similarities.put(pair, 1.0);
        } else {
            similarities.put(pair, similarities.get(pair) + 1); // increment the similarity count by 1
        }
    }

    private HashMapList<Integer,Integer> groupWords(HashMap<Integer,Document> documents) {
        HashMapList<Integer, Integer> wordToDocs = new HashMapList<>();

        // map the word to each of the documents
        // word -> {doc1, doc2, doc3, etc}
        for (Document doc: documents.values()) {
            ArrayList<Integer> words = doc.getWords();
            for (int word: words) {
                wordToDocs.put(word, doc.getId());
            }
        }

        return wordToDocs;
    }
}
