package Redo.TreesAndGraph;

import java.util.LinkedList;

public class RouteBetweenNodes {

    public enum State {Visited, Visiting, Unvisited}

    private boolean foundRoute(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> queue = new LinkedList<>();

        for (Node n: g.getNodes()) {
            n.state = State.Unvisited;
        }

        start.state = State.Visiting;
        queue.add(start);
        Node u;

        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            if (u != null) {
                for (Node adj: u.getAdjacents()) {
                    if (adj.state == State.Unvisited) {
                        if (adj == end) {
                            return true;
                        } else {
                            adj.state = State.Visiting;
                            queue.add(adj);
                        }
                    }
                }

                u.state = State.Visited;
            }
        }

        return false;
    }
}
