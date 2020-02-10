public class BuildOrder {
    public Project[] createBuildOrder(String[] projectNames, String[][] dependencies) {
        Graph graph = createGraph(projectNames);
        graph.addDependencies(dependencies);
        return createBuildOrder(graph.getNodes());
    }

    public Graph createGraph(String[] projectNames) {
        Graph graph = new Graph();

        for (String projectName: projectNames) {
            graph.createNode(projectName);
        }

        return graph;
    }

    public Project[] createBuildOrder(List<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int processingIndex = 0;
        while (processingIndex < order.length) {
            Project current = order[processingIndex];

            if (current == null) {
                return null;
            }

            ArrayList<Project> children = current.getChildren();
            for (Project child: children) {
                child.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);
            processingIndex++;
        }

        return order;
    }

    public int addNonDependent(Project[] order, List<Project> projects, int offset) {
        for (Project project: projects) {
            if (projects.getNumberOfDependencies() == 0) {
                order[offset++] = project;
            }
        }

        return offset;
    }
}