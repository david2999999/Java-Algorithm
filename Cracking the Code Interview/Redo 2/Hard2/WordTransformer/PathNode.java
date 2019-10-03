package Hard2.WordTransformer;

import java.util.LinkedList;

public class PathNode {
    private String word = null; // the current word in this node
    private PathNode previousNode = null;   // keeps track of the previous word

    public PathNode(String word, PathNode previousNode) {
        this.word = word;
        this.previousNode = previousNode;
    }

    public String getWord() {
        return word;
    }

    public LinkedList<String> collapse(boolean startsWithRoot) {
        LinkedList<String> path = new LinkedList<>();
        PathNode node = this;   // start with the current node

        while (node != null) {
            if (startsWithRoot) {   // if you want the root to be at the front of the list
                path.addLast(node.word);    // add each word to the end of the list
            } else {
                path.addFirst(node.word);   // the root will be at the end of the list
            }
        }

        return path;
    }
}
