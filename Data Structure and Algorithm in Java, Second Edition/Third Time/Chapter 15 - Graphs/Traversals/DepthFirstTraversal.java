public class DepthFirstTraversal {
    public <E> void search(Vertex<E> vertex) {
        visit(vertex);
        vertex.visited = true;

        for (Vertex<E> neighbor: vertex.neighbors) {
            if (!neighbor.visited) {
                search(neighbor);
            }
        }
    }

    private <E> void visit(Vertex<E> vertex) {
        System.out.println("Visited = " + vertex);
    }
}