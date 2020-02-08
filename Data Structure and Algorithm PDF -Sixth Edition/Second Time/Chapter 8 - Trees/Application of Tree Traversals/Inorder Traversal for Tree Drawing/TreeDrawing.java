public class TreeDrawing {
    public static <E> int layout(BinaryTree<E> tree, Position<E> p,
                                 int yAxis, int xAxis) {
        if (tree.left(p) != null) {
            xAxis = layout(tree, tree.left(p), yAxis + 1, xAxis);
        }

        p.getElement().setX(xAxis++);
        p.getElement().setY(yAxis);

        if (tree.right(p) != null) {
            xAxis = layout(tree, tree.right(p), yAxis + 1, xAxis);
        }

        return xAxis;
    }
}