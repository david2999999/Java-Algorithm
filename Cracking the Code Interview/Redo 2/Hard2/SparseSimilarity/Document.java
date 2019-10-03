package Hard2.SparseSimilarity;

import java.util.ArrayList;

public class Document {
    private int docId;
    private ArrayList<Integer> words;

    public Document(int docId, ArrayList<Integer> words) {
        this.docId = docId;
        this.words = words;
    }

    public int getId() {
        return docId;
    }

    public ArrayList<Integer> getWords() {
        return words;
    }

    public int size() {
        return words == null ? 0 : words.size();
    }
}
