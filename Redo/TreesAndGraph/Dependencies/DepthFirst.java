package Redo.TreesAndGraph.Dependencies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DepthFirst {
    private Stack<Project> getOrder(String[] project, String[][] dependencies) {
        Graph graph = buildGraph(project, dependencies);
        return buildOrder(graph.getNodes());
    }

    private Stack<Project> buildOrder(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project: projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }

        return stack;
    }

    private boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) return false;

        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);

            ArrayList<Project> children = project.getChildren();

            for (Project child: children) {
                if (!doDFS(child, stack)) return false;
            }

            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }

        return true;
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
