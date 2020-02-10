public class GraphNode<E> implements Node<E> {
    private String name;
    private E value;
    private List<Node<E>> neighbors = new ArrayList<>();

    public GraphNode(String name, E value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Node<E>> getNeighbors() {
        return neighbors;
    }

    @Override
    public void addNeighbor(Node<E> node) {
        this.neighbors.add(node);
    }

    @Override
    public E getValue() {
        return value;
    }

    @Override
    public void setValue(E value) {
        this.value = value;
    }

}