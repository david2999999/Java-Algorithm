public interface Graph {
    void addEdge(String start, String end);
    void createNode(String name);
    Node getOrCreateNode(String name);
}