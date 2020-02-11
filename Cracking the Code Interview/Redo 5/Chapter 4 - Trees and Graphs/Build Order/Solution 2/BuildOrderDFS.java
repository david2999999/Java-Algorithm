public class BuildOrderDFS {
    public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = createGraph(projects);
        graph.addDependencies(dependencies);
        return orderProject(graph.getNodes());
    }

    private Stack<Project> orderProject(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project: projects) {
            if (project.getState == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }

        return stack;
    }

    public boolean doDFS(Project project, Stack<Project> buildOrder) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;
        }

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);

            for (Project child: project.getChildren()) {
                if (!doDFS(child)) {
                    return false;
                }
            }

            project.setState(Project.State.COMPLETE);
            buildOrder.push(project);
        }

        return true;
    }

    public Graph createGraph(String[] projectNames) {
        Graph graph = new Graph();

        for (String projectName: projectNames) {
            graph.createNode(projectName);
        }

        return graph;
    }
}