public class AdjacencyMapGraph {
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
}