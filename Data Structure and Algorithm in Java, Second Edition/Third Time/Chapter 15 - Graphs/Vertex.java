public class Vertex<E> {
    public E value;
    public List<Edge> edges;
    public List<Vertex<E>> neighbors;
    public boolean done;
    public int distance;
    public Vertex<E> back;
    public boolean visited;
}