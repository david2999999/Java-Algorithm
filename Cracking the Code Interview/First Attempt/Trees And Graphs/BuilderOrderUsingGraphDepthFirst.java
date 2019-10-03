package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BuilderOrderUsingGraphDepthFirst {

    private Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Stack<Project> orderProjects(ArrayList<Project> projects) {
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

            for (Project child : project.getChildren()) {
                if (!doDFS(child, stack)) return false;
            }

            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }

        return true;
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


}

class Project {
    public enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
