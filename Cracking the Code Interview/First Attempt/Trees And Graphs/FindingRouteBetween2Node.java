package TreesAndGraphs;

import java.util.LinkedList;

public class FindingRouteBetween2Node {
    enum State {Unvisited, Visited, Visiting}

    public boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> q = new LinkedList<>();

        for (Node n: g.getNodes()) {
            n.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        Node u;

        while (!q.isEmpty()){
            u = q.removeFirst();

            if (u != null) {
                for (Node v: u.getAdjacents()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }

                u.state = State.Visited;
            }
        }

        return false;
    }
}
