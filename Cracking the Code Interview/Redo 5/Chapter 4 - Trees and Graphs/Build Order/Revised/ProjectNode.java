public class ProjectNode implements Project {
    private String name;
    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();
    private int dependencies = 0;

    public ProjectNode(String name) {
        this.name = name;
    }

    public List<Node> getNeighbors() {
        return children;
    }

    public void addNeighbor(Node node) {
        if (!map.contains(node.getName())) {
            ProjectNode projectNode = new ProjectNode(node.getName());
            map.put(node.getName(), projectNode);
            children.add(projectNode);
            projectNode.incrementDependencies();
        }
    }

    public void decrementDependencies() {
        this.dependencies--;
    }

    public void incrementDependencies() {
        this.dependencies++;
    }

    public int getNumberOfDependencies() {
        return dependencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}