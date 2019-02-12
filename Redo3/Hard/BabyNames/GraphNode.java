package Hard.BabyNames;

import java.util.ArrayList;

public class GraphNode {
    private String name;
    private boolean visited;
    private int frequency;
    private ArrayList<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ArrayList<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode node) {
        neighbors.add(node);
        node.getNeighbors().add(this);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setNeighbors(ArrayList<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }
}
