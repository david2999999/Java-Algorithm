package TreesAndGraph.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();   // all projects are treated as nodes in a graph
    private HashMap<String, Project> map = new HashMap<>(); // quick lookup of project based on names

    // get a project based on its name
    public Project getOrCreateNode(String name) {

        // if the project does not exist, create a new one
        if (!map.containsKey(name)) {
            Project node = new Project(name);   // new project
            nodes.add(node);    // add to list
            map.put(name, node);    // add to map
        }

        return map.get(name);   // return the project
    }

    // connecting two projects together
    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName); // get the first project
        Project end = getOrCreateNode(endName); // get the second project
        start.addNeighbor(end); // the first project has to be built first, before the second project
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}













