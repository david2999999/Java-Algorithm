package SystemDesign.Cache;

import java.util.HashMap;

public class Cache {
    public static int MAX_SIZE = 10;
    public Node head, tail;
    public HashMap<String, Node> map;
    private int size = 0;

    public Cache() {
        this.map = new HashMap<>();
    }

    public void moveToFront(Node node){}
    public void moveToFront(String query) {}

    public void removeFromList(Node node) {}

    public String[] getResults(String query) {
        if (!map.containsKey(query)) return null;

        Node node = map.get(query);
        moveToFront(node);
        return node.results;
    }

    public void insertResult(String query, String[] result) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.results = result;
            moveToFront(node);
            return;
        }

        Node node = new Node(query, result);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromList(tail);
        }


    }
}
