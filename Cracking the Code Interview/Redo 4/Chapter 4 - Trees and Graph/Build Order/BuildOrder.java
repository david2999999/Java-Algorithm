public class BuildOrder {
    public Project[] findBuilderOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependents(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if (current == null) return null;

            ArrayList<Project> children = current.getChildren();
            for (Project child: children) {
                child.decrementDependencies();
            }

            endOfList = addNonDependents(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    private int addNonDependents(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset++] = project;
            }
        }

        return offset;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project: projects) {
            graph.createNode(project);
        }

        for (String[] dependency: dependencies) {
            String first = dependencies[0];
            String second = dependencies[1];
            graph.addEdge(first, second);
        }

        return graph;
    }
}