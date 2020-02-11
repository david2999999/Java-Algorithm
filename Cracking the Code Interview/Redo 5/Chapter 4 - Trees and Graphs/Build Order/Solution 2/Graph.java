public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project project = new Project(name);
            nodes.add(project);
            map.put(name, project);
        }

        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);

        start.addNeighbor(end);
    }

    public void createNode(String name) {
        if (!map.containsKey(name)) {
            Project newProject = new Project(name);
            nodes.add(newProject);
            map.put(name, newProject);
        }
    }

    public void addDependencies(String[][] dependencies) {
        for (String[] element: dependencies) {
            String dependency = element[0];
            String dependent = element[1];
            addEdge(dependency, dependent);
        }
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}