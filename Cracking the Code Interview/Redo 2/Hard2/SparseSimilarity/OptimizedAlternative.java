package Hard2.SparseSimilarity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OptimizedAlternative {
    public HashMap<DocPair, Double> computeSimilarities(HashMap<Integer, Document> documents) {
        ArrayList<Element> elements = sortWords(documents);
        HashMap<DocPair, Double> similarities = computeIntersections(elements);
        adjustSimilarities(documents, similarities);
        return similarities;
    }

    private void adjustSimilarities(HashMap<Integer,Document> documents, HashMap<DocPair,Double> similarities) {
        for (Map.Entry<DocPair, Double> entry: similarities.entrySet()) {
            DocPair pair = entry.getKey();
            Double intersection = entry.getValue();

            Document doc1 = documents.get(pair.doc1);
            Document doc2 = documents.get(pair.doc2);

            double union = doc1.size() + doc2.size() - intersection;
            entry.setValue(union / intersection);
        }
    }

    private HashMap<DocPair,Double> computeIntersections(ArrayList<Element> elements) {
        HashMap<DocPair, Double> similarities = new HashMap<>();

        for (int i = 0; i < elements.size(); i++) {
            Element left = elements.get(i);
            for (int j = i + 1; j < elements.size(); j++) {
                Element right = elements.get(j);

                if (left.word != right.word) {
                    break;
                }

                increment(similarities, left.document, right.document);
            }
        }

        return similarities;
    }

    private void increment(HashMap<DocPair,Double> similarities, int doc1, int doc2) {
        DocPair pair = new DocPair(doc1, doc2);

        // if we have not this pair yet in the hashmap
        if (!similarities.containsKey(pair)) {
            similarities.put(pair, 1.0);    // set the similarity count to 1
        } else {
            // increment the similarity count
            similarities.put(pair, similarities.get(pair) + 1);
        }
    }

    private ArrayList<Element> sortWords(HashMap<Integer,Document> docs) {
        ArrayList<Element> elements = new ArrayList<>();
        for (Document doc: docs.values()) {
            ArrayList<Integer> words = doc.getWords();
            for (int word: words) {
                // add the word and its associated doc id
                elements.add(new Element(word, doc.getId()));
            }
        }

        // sort the elements
        Collections.sort(elements);
        return elements;
    }
}
