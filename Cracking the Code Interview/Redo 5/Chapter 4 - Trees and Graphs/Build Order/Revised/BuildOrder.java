public class BuildOrder {
    public static void main(String[] args) {
        String[] projectNames = {
                "a", "b", "c", "d", "e", "f", "g"
        };

        String[][] dependencies = {
                {"f", "c"}, {"f", "b"}, {"f", "a"}, {"c", "a"}, {"b", "a"}, {"b", "e"}, {"a", "e"}, {"d", "g"}
        };

        createBuildOrder(projectNames, dependencies);

        List<Node<DependencyProject>> buildOrder = createBuildOrder(projectNames, dependencies);

        System.out.print("Project order = ");
        for (Node<DependencyProject> node: buildOrder) {
            System.out.print(node.getValue().getName() + ", ");
        }
    }

    private static List<Node<DependencyProject>> createBuildOrder(String[] projectNames, String[][] dependencies) {
        Graph<DependencyProject> graph = createProjectGraph(projectNames);
        createDependencies(graph, dependencies);
        System.out.println(graph.toString());


        return createBuildOrder(graph.getNodes());
    }

    private static List<Node<DependencyProject>> createBuildOrder(List<Node<DependencyProject>> nodes) {
        List<Node<DependencyProject>> buildOrder = new ArrayList<>(nodes.size());

        int lastIndex = getNonDependentProjects(nodes, buildOrder, 0);

        int currentIndex = 0;
        while (currentIndex < nodes.size()) {
            Node<DependencyProject> node = buildOrder.get(currentIndex);

            if (node == null) {
                return null;
            }

            for (Node<DependencyProject> child: node.getNeighbors()) {
                child.getValue().decrementDependencies();
            }


            lastIndex = getNonDependentProjects(node.getNeighbors(), buildOrder, lastIndex);
            currentIndex++;
        }

        return buildOrder;
    }

    private static int getNonDependentProjects(List<Node<DependencyProject>> nodes, List<Node<DependencyProject>> buildOrder, int offset) {
        for (Node<DependencyProject> node: nodes) {
            DependencyProject project = node.getValue();
            if (project.isReadyToBeBuilt()) {
                buildOrder.add(offset++, node);
            }
        }

        return offset;
    }

    private static void createDependencies(Graph<DependencyProject> graph, String[][] dependencies) {
        for (String[] dependency: dependencies) {
            String start = dependency[0];
            String end = dependency[1];

            graph.addEdge(start, end);
        }
    }

    private static Graph<DependencyProject> createProjectGraph(String[] projectNames) {
        Graph<DependencyProject> graph = new ProjectGraph<>();

        for (String projectName: projectNames) {
            graph.createNode(projectName, new Project(projectName));
        }

        return graph;
    }
}