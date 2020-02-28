public class Cache {
    public static final int MAX_SIZE = 10;
    public Node head, tail;
    public HashMap<String, Node> map;
    public int size;

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
        return node.results;
    }

    public void insertResults(String query, String[] results) {
        if (map.containsKey(query)) {
            Node node = map.get(query);
            node.results = results;
            moveToFront(node);
            return;
        }

        Node node = new Node(query, results);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.query);
            removeFromLinkedList(node);
        }
    }
}