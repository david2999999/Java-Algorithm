public class TreeDrawing {
    public static <E> int layout(BinaryTree<E> T, Position<E> p, int d, int x) {
        if (T.left(p) != null) 
            x = layout(T, T.left(p), d + 1, x);
            
        p.getElement().setX(x++);
        p.getElement().setY(d);
        
        if (T.right(p) != null)
            x = layout(T, T.right(p), d + 1, x);
            
        return x;
    }
}