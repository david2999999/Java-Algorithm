package Hard.BabyNames;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    private HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
        Graph graph = constructGraph(names);
        connectEdge(graph, synonyms);
        return getTrueFrequency(graph);
    }

    private HashMap<String,Integer> getTrueFrequency(Graph graph) {
        HashMap<String, Integer> rootNames = new HashMap<>();
        for (GraphNode node : graph.getNodes()) {
            if (!node.isVisited()) {
                int frequency = getComponentFrequency(node);
                String name = node.getName();
                rootNames.put(name, frequency);
            }
        }

        return rootNames;
    }

    private int getComponentFrequency(GraphNode node) {
        if (node.isVisited()) return 0;

        node.setVisited(true);
        int sum = node.getFrequency();

        for (GraphNode child: node.getNeighbors()) {
            sum += getComponentFrequency(child);
        }

        return sum;
    }

    private void connectEdge(Graph graph, String[][] synonyms) {
        for (String[] entry: synonyms) {
            String name1 = entry[0];
            String name2 = entry[1];
            graph.addEdge(name1, name2);
        }
    }

    private Graph constructGraph(HashMap<String,Integer> names) {
        Graph graph = new Graph();
        for (Map.Entry<String, Integer> entry: names.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            graph.createNode(name, frequency);
        }
        return graph;
    }
}
