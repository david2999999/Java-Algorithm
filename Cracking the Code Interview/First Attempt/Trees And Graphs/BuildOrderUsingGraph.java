package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrderUsingGraph {

    public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        for (String project: projects) {
            graph.createNode(project);
        }

        for (String[] dependency: dependencies) {
            String start = dependency[0];
            String end = dependency[1];
            graph.addEdge(start, end);
        }

        return graph;
    }


    private Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int tobeProcessed = 0;
        while (tobeProcessed < order.length) {
            Project current = order[tobeProcessed];

            if (current == null) return null;

            for (Project children: current.getChildren()) {
                children.decrementDependencies();
            }

            endOfList = addNonDependent(order, projects, endOfList);
            tobeProcessed++;
        }

        return order;
    }

    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }

        return offset;
    }

    private class Graph {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreateNode(String name) {
            if (!map.containsKey(name)) {
                this.createNode(name);
            }

            return map.get(name);
        }

        public void createNode(String projectName) {
            Project newProject = new Project(projectName);
            nodes.add(newProject);
            map.put(newProject.getName(), newProject);
        }

        public void addEdge(String startName, String endName) {
            Project start = this.getOrCreateNode(startName);
            Project end = this.getOrCreateNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    private class Project {
        private ArrayList<Project> children = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies;

        public Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
                node.incrementDependencies();
            }
        }

        public void decrementDependencies() {
            this.dependencies--;
        }

        public void incrementDependencies() {
            this.dependencies++;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }

        public HashMap<String, Project> getMap() {
            return map;
        }

        public int getDependencies() {
            return dependencies;
        }
    }
}
