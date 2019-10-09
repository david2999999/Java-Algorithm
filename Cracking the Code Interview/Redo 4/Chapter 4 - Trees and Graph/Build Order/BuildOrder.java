public class BuildOrder {
    public Project[] findBuilderOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
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