public interface Graph<E> {
    void addEdge(String start, String end);
    void createNode(String name, E value);
    List<Node<E>> getNodes();
}