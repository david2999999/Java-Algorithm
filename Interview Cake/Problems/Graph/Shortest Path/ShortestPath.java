public class ShortestPath {
    public void breathFirstSearch(Map<String, String>[] graph, String startNode, String endNode) {
        Queue<String> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.add(startNode);

        Set<String> nodesAlreadySeen = new HashSet<>();
        nodesAlreadySeen.add(startNode);

        while (!nodesToVisit.isEmpty()) {
            String currentNode = nodesToVisit.remove();

            if (currentNode == endNode) {
                break;
            }

            for (String neighbor: graph.get(currentNode)) {
                if (!nodesAlreadySeen.contains(neighbor)) {
                    nodesAlreadySeen.add(neighbor);
                    nodesToVisit.add(neighbor);
                }
            }
        }
    }
}