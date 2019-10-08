public class RouteBetweenNodes {
    private enum State {
        UNVISITED, VISITED, VISITING;
    }

    public boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> queue = new LinkedList<>();

        for (Node u: g.getNodes()) {
            u.state = State.UNVISITED;
        }

        start.state = State.VISITING;
        queue.add(start);
        Node current;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current != null) {
                for (Node neighbor: current.getAdjacent()) {
                    if (neighbor.state == State.UNVISITED) {
                        if (neighbor == end) {
                            return true;
                        } else {
                            neighbor.state = State.VISITING;
                            queue.add(neighbor);
                        }
                    }
                }
            }

            current.state = State.VISITED;
        }

        return false;
    }
}