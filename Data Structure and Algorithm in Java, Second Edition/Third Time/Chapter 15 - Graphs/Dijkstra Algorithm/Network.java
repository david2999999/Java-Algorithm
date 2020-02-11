public class Network<E> {
    private List<Vertex<E>> vertexes = new ArrayList<>();
    private Vertex<E> start = new Vertex<E>();

    private static class Vertex<E> {
        public E value;
        public List<Edge> edges;
        public List<Vertex<E>> neighbors;
        public boolean done;
        public int distance;
        public Vertex<E> back;
    }

    private class Edge<E> {
        public Vertex<E> to;
        public int weight;
    }

    public Network() {
        start.distance = 0;
        for (Vertex<E> vertex: vertexes) {
            vertex.distance = Integer.MAX_VALUE;
        }
    }

    public void findShortestPaths() {
        for (Vertex<E> currentVertex = start; currentVertex != null; currentVertex = closestVertex(currentVertex)) {
            for (Edge<E> edge: currentVertex.edges) {
                Vertex<E> to = edge.to;
                if (!to.done && currentVertex.distance + edge.weight < to.distance) {
                    to.distance = currentVertex.distance + edge.weight;
                    to.back = currentVertex;
                }
            }

            currentVertex.done = true;
        }
    }

    private Vertex<E> closestVertex(Vertex<E> vertex) {
        Vertex closestVertex = null;
        int minDistance = Integer.MAX_VALUE;

        for (Vertex<E> neighbor: vertex.neighbors) {
            if (!neighbor.done && neighbor.distance < minDistance) {
                closestVertext = neighbor;
                minDistance = neighbor.distance;
            }
        }

        return closestVertex;
    }
}