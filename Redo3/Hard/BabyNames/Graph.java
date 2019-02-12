package Hard.BabyNames;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private ArrayList<GraphNode> nodes = new ArrayList<>();
    private HashMap<String, GraphNode> map = new HashMap<>();

    public void createNode(String name, int frequency) {
        if (!map.containsKey(name)) {
            GraphNode node = new GraphNode(name, frequency);
            nodes.add(node);
            map.put(name, node);
        }
    }

    public ArrayList<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public HashMap<String, GraphNode> getMap() {
        return map;
    }

    public void setMap(HashMap<String, GraphNode> map) {
        this.map = map;
    }

    public void addEdge(String name1, String name2) {
        GraphNode node1 = map.get(name1);
        GraphNode node2 = map.get(name2);

        node1.addNeighbor(node2);
    }
}
