public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> pos;
        private Map<Vertex<E>, Edge<E>> outgoing, incoming;

        public innerVertex(V element, boolean graphIsDirected) {
            this.element = element;
            outgoing = new ProbeHashMap<>();

            if (graphIsDirected) {
                incoming = new ProbeHashMap<>();
            } else {
                incoming = outgoing;
            }
        }

        public V getElement() {
            return element;
        }

        public Position<Vertex<V>> getPosition() {
            return pos;
        }

        public void setPosition(Position<Vertex<V>> pos) {
            this.pos = pos;
        }

        public Map<Vertex<E>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Map<Vertex<E>, Edge<E>> getIncoming() {
            return incoming;
        }
    }

    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Position<Edge<E>> position;
        private Vertex<V>[] endpoints;

        public InnerEdge(Vertex<V> u, Vertex<V> v, E element) {
            this.element = element;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};
        }

        public E getElement() {
            return element;
        }

        public Position<Edge<E>> getPosition() {
            return position;
        }

        public void setPosition(Position<Edge<E>> position) {
            this.position = position;
        }

        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }
    }

    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

    public AdjacencyMapGraph(boolean directed) {
        this.isDirected = directed;
    }

    public int numVertices() {
        return vertices.size();
    }

    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    public int numEdges() {
        return edges.size();
    }

    public Iterable<Edge<E>> edges() {
        return edges;
    }

    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.getOutgoing().size();
    }

    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);
        return vert.getOutgoing().values();
    }

    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);
        return vert.getIncoming().size();
    }

    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vert = validate(v);
        return vert.getIncoming().values();
    }

    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> origin = validate(u);
        return origin.getOutgoing().get(v);
    }

    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        return edge.getEndpoints();
    }

    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        Vertex<V>[] endpoints = edge.getEndpoints();

        if (endpoints[0] == v) {
            return endpoints[1];
        } else if (endpoints[1] == v) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("v is not incident to this edge.");
        }
    }

    public Vertex<V> insertVertex(V element) {
        InnerVertex<V> v = new InnerVertex<>(element, isDirected);
        v.setPosition(vertices.addLast(v));
        return v;
    }

    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
        if (getEdge(u, v) == null) {
            InnerEdge<E> e = new InnerEdge<>(u, v, element);
            e.setPosition(edges.addLast(e));

            InnerVertex<V> origin = validate(u);
            InnerVertex<V> dest = validate(v);
            origin.getOutgoing().put(v, e);
            dest.getIncoming().put(u, e);
            return e;
        } else {
            throw new IllegalArgumentException("Edge from u to v exists.");
        }
    }
}