public interface Node {
    String getName();
    void setName(String name);
    List<Node> getNeighbors();
    void addNeighbor(Node node);
}