public class BreathFirstSearch {
    public static <E> void search(Vertex<E> start) {
        Vector<E> queue = new Vector<>();
        visit(start);
        start.visited = true;
        queue.addElement(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.firstElement();
            queue.removeElementAt(0);

            for (Edge edge: current.edges) {
                Vertex to = edge.to;

                if (!to.visited) {
                    visit(to);
                    to.visited = true;
                    queue.addElement(to);
                }
            }
        }
    }

    private static <E> void visit(Vertex<E> vertex) {
        System.out.println("Visited = " + vertex);
    }
}