public class ShortestPathOptimized {
    public String[] breathFirstSearchGetPath(Map<String, String[]> graph, String startNode, String endNode) {
        if (!graph.containsKey(startNode)) {
            throw new IllegalArgumentException("Start node not in graph");
        }

        if (!graph.containsKey(endNode)) {
            throw new IllegalArgumentException("End node not in graph");
        }

        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        Map<String, String> howWeReachNodes = new HashMap<>();
        howWeReachNodes.put(startNode, null);

        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.remove();

            if (currentNode.equals(endNode)) {
                return reconstructPath(howWeReachNodes, startNode, endNode);
            }

            for (String neighbor: graph.get(currentNode)) {
                if (!howWeReachNodes.containsKey(neighbor)) {
                    nodesToVisit.add(neighbor);
                    howWeReachNodes.put(neighbor, currentNode);
                }
            }
        }

        return null;
    }

    private String[] reconstructPath(Map<String, String> previousNodes, String startNode, String endNode) {
        List<String> reverseShortedPath = new ArrayList<>();
        String currentNode = endNode;

        while (currentNode != null) {
            reverseShortedPath.add(currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        Collections.reverse(reverseShortedPath);
        return reverseShortedPath.toArray(new String[reverseShortedPath.size()]);
    }
}