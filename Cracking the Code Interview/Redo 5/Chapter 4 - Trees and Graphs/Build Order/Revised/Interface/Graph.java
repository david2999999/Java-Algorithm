public interface Graph {
    void addEdge(Node start, Node end);
    void createNode(String name);
    Node getOrCreateNode(String name);
}