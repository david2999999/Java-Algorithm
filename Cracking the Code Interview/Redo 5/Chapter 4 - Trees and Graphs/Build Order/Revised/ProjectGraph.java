public class ProjectGraph implements Graph {
    private List<Node> projectNodes = new ArrayList<>();
    private Map<String, Node> map = new HashMap<>();

    public void addEdge(String start, String end) {
        Node startingNode = getOrCreateNode(start);
        Node endingNode = getOrCreateNode(end);

        startingNode.addNeighbor(endingNode);
    }

    public void createNode(String name) {
        if (!map.containsKey(name)) {
            Node project = new ProjectNode(name);
            projectNodes.add(project);
            map.put(name, project);
        }
    }

    public Node getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Node newNode = new ProjectNode(name);
            projectNodes.add(newNode);
            map.put(name, newNode);
        }

        return map.get(name);
    }
}