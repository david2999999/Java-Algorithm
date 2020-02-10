public class ProjectGraph<E extends DependencyProject> implements Graph<E> {
    private List<Node<E>> nodes = new ArrayList<>();
    private Map<String, Node<E>> map = new HashMap<>();

    @Override
    public void createNode(String name, E value) {
        if (!map.containsKey(name)) {
            Node<E> newNode = new GraphNode<>(name, value);
            nodes.add(newNode);
            map.put(name, newNode);
        }
    }

    @Override
    public void addEdge(String start, String end) {
        if (!map.containsKey(start) || !map.containsKey(end)) return;

        Node<E> startingNode = map.get(start);
        Node<E> endingNode = map.get(end);

        startingNode.addNeighbor(endingNode);
        endingNode.getValue().incrementDependencies();
    }

    @Override
    public List<Node<E>> getNodes() {
        return this.nodes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Node<E> node: getNodes()) {
            sb.append("Parent = " + node.getName() + "\n");
            sb.append("\t children = ");

            for (Node<E> neighbor: node.getNeighbors()) {
                sb.append(neighbor.getValue().getName() + ", ");
            }

            sb.append("\n");
        }

        sb.append("\n");
        return sb.toString();
    }
}