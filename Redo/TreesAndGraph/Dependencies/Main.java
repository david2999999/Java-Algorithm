package Redo.TreesAndGraph.Dependencies;


import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private Project[] getOrderOfProject(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return buildOrder(graph.getNodes());
    }

    private Project[] buildOrder(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        // used to keep track of which index to insert the project
        int index = 0;
        index = getNondependent(order, projects, index);

        // used to keep track of which project the program is checking
        int processing = 0;
        while (processing < order.length) {
            Project current = order[processing];

            if (current == null) {
                return null; // circular dependency
            }

            ArrayList<Project> children = current.getChildren();
            for (Project project: children) {
                project.decrementDependencies();
            }

            index = getNondependent(order, children, index);
            processing++;
        }

        return order;
    }

    private int getNondependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }

        return offset;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String projectName: projects) {
            graph.getOrCreate(projectName);
        }

        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    private class Graph {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreate(String projectName) {
            if (!map.containsKey(projectName)) {
                Project newProject = new Project(projectName);
                nodes.add(newProject);
                map.put(projectName, newProject);
            }

            return map.get(projectName);
        }

        public void addEdge(String p1, String p2) {
            Project project1 = getOrCreate(p1);
            Project project2 = getOrCreate(p2);
            project1.addNeighbor(project2);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }
}
