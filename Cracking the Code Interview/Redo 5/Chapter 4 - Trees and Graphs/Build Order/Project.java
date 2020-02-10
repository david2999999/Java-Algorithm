public class Project {
    private String name;
    private int dependencies = 0;

    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public class Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            map.put(node.getName(), node);
            children.add(node);
            node.incrementDependencies();
        }
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public int getNumberOfDependencies() {
        return dependencies;
    }
}