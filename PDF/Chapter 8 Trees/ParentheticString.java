public class ParentheticString {
    public static <E> parenthesize(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement());
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c: T.children(p)) {
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(T, c);
            }
        }
        
        System.out.print(")");
    }
}