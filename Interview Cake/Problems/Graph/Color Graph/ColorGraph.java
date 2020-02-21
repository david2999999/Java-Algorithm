public class ColorGraph {
    public void colorGraph(GraphNode[] graph, String[] colors) {
        for (GrapNode node: graph) {
            Set<GraphNode> neighbors = node.getNeighbors();

            if (neighbors.contains(node)) {
                throw new IllegalArgumentException("Legal coloring impossible with loop");
            }

            HashSet<String> illegalColors = new HashSet<>();
            for (GraphNode neighbor: neighbors) {
                if (neighbor.hasColor()) {
                    illegalColors.add(neighbor.getColor());
                }
            }

            for (String color: colors) {
                if (!illegalColors.contains(color)) {
                    node.setColor(color);
                    return;
                }
            }
        }
    }
}