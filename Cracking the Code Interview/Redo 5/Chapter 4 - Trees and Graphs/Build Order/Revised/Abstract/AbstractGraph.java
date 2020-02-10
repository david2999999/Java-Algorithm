public class AbstractGraph implements Graph {
    private List<Node> nodes = new ArrayList<>();
    private Map<String, Node> map = new HashMap<>();

    public void addEdge(String start, String end) {
        Node startingNode = getOrCreateNode(start);
        Node endingNode = getOrCreateNode(end);

        startingNode.addNeighbor(endingNode);
    }

    public void createNode(String name) {
        if (!map.containsKey(name)) {
            Node newNode = createCustomNode(name);
            nodes.add(newNode);
            map.put(name, newNode);
        }
    }

    public Node getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Node newNode = createCustomNode(name);
            nodes.add(newNode);
            map.put(name, newNode);
        }

        return map.get(name);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    protected abstract Node createCustomNode(String name);
}