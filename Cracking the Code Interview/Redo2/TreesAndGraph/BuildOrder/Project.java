package TreesAndGraph.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    // list of dependents, this project has to be built first before its children
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>(); // hashmap for quick lookup of children or dependents

    private String name;    // name of this project
    private int dependencies = 0;   // number of projects that needs to be build, before this project can be built

    // simple constructor with project name
    public Project(String name) {
        this.name = name;
    }

    // add projects that needs this project to be built first
    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) { // if the project does not contain in the map
            children.add(node); // add the project to its children
            map.put(node.getName(), node);  // add the project to the map
            node.incrementDependencies();   // add a dependency to that project
        }
    }

    public void incrementDependencies() { dependencies++; }
    public void decrementDependencies() { dependencies--; }

    // simple getters
    public ArrayList<Project> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getNumberDependencies() {
        return dependencies;
    }
}
