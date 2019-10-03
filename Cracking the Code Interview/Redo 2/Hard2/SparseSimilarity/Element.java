package Hard2.SparseSimilarity;

public class Element implements Comparable<Element>{
    public int word, document;

    public Element(int word, int document) {
        this.word = word;
        this.document = document;
    }


    @Override
    public int compareTo(Element e) {
        if (word == e.word) {
            return document - e.document;
        }

        return word - e.word;
    }
}
