public class Route {
    private Enum State {
        UNVISITED, VISITED, VISITING;
    }

    public boolean search(Graph q, Node start, Node end) {
        if (start == null || end == null) return false;
        if (start == end) return true;

        for (Node node: q.getNodes()) {
            node.setState(State.UNVISITED);
        }

        Queue<Node> queue = new LinkedList<>();
        start.setState(State.VISITING);
        queue.add(start);
        Node currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.removeFirst();

            for (Node adjacentNode: currentNode.getAdjacent()) {
                if (adjacentNode.getState() == State.UNVISITED) {
                    if (adjacentNode == end) {
                        return true;
                    } else {
                        adjacentNode.setState(State.VISITING);
                        queue.add(adjacentNode);
                    }
                }
            }

            currentNode.setState(State.VISITED);
        }

        return false;
    }
}