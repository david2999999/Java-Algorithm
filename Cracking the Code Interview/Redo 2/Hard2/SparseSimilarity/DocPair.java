package Hard2.SparseSimilarity;

import java.util.Objects;

public class DocPair {
    public int doc1, doc2;

    public DocPair(int doc1, int doc2) {
        this.doc1 = doc1;
        this.doc2 = doc2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPair docPair = (DocPair) o;
        return doc1 == docPair.doc1 &&
                doc2 == docPair.doc2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doc1, doc2);
    }
}
