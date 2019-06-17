package Redo.SystemDesign;

import java.util.HashMap;

public class Cache {
    public static final int MAX_SIZE = 10;
    public Node head, tail;
    public HashMap<String, Node> map;
    public int size = 0;

    public Cache() {
        map = new HashMap<>();
    }

    public void moveToFront(Node node) {}
    public void moveToFront(String query) {}

    public void removeFromLinkedList(Node node) {}

    public String[] getResults(String query) {
        if (!map.containsKey(query)) {
            return null;
        }

        Node node = map.get(query);
        moveToFront(node);
        return node.result;
    }


    public void insertResult(String query, String[] result) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.result = result;
            moveToFront(node);
            return;
        }

        Node node = new Node(query, result);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromLinkedList(tail);
        }
    }

    private class Node {
        public String query;
        public String[] result;

        public Node(String query, String[] result) {
            this.query = query;
            this.result = result;
        }
    }
}
