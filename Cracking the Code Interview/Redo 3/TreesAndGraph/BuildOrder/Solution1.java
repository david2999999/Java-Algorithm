package TreesAndGraph.BuildOrder;

import java.util.ArrayList;

public class Solution1 {
    public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < projects.size()) {
            Project current = order[toBeProcessed];

            if (current == null) {
                return null;
            }

            ArrayList<Project> children = current.getChildren();
            for (Project project: children) {
                project.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getDependencies() == 0) {
                order[offset++] = project;
            }
        }

        return offset;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project: projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }
}
