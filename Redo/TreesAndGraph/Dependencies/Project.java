package Redo.TreesAndGraph.Dependencies;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project p) {
        if (p == null) return;

        if (!map.containsKey(p.name)) {
            children.add(p);
            map.put(p.name, p);
            p.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        this.dependencies++;
    }

    public void decrementDependencies() {
        this.dependencies--;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public HashMap<String, Project> getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public int getDependencies() {
        return dependencies;
    }
}
