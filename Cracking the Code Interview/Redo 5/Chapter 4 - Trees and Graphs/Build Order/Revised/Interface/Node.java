public interface Node<E> {
    String getName();
    void setName(String name);
    List<Node<E>> getNeighbors();
    void addNeighbor(Node<E> node);
    E getValue();
    void setValue(E value);
}