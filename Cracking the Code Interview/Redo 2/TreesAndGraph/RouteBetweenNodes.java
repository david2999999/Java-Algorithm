package TreesAndGraph;

import java.util.LinkedList;

// given a directed graph design an algorithm to find out where there is a route between two nodes
public class RouteBetweenNodes {
    private enum State { Unvisited, Visited, Visiting}; // state of the nodes in the graph

    // creating an inner graph node class
    private static class Node {
        public State state;
        public Node[] adjacents;

        public Node[] getAdjacents() {  // get all of the adjacent nodes or nodes that are connected with
            return adjacents;           // the current node
        }
    }

    // creating an inner graph class
    private static class Graph {
        // need a list of nodes
        private Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }

    // method to search the graph for a route
    public boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;  // the start is equal to the end, route is complete

        LinkedList<Node> q = new LinkedList<>();    // operates as a queue

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;  // set all of the states of the nodes inside the graph to unvisited
        }

        start.state = State.Visiting;   // label as the node that we are currently visiting
        q.add(start);
        Node u;

        while (!q.isEmpty()) {
            u = q.removeFirst();    // dequeue
            if (u != null) {
                for (Node v : u.getAdjacents()) {   // get all of the neighboring nodes
                    if (v.state == State.Unvisited) {   // if we haven't visit the node yet
                        if (v == end) { // we have found the end node, so there is a route
                            return true;
                        } else {
                            v.state = State.Visiting;   // set the state to visiting
                            q.add(v);   // added to queue
                        }
                    }
                }
                u.state = State.Visited;    // we have finished visiting this node
            }
        }

        return false;   // we have not found a route
                        // this method is breadth first search, in which we look through all
                        // of the neighbors of the current node first, before looking at neighbors
                        // of neighbor nodes.
    }
}




















