public class ParentheticRepresentation {
    public static <E> void parenthesize(Tree<E> tree, Position<E> p) {
        System.out.print(p.getElement());

        if (tree.isInternal(p)) {
            boolean firstTime = true;

            for (Position<E> child: tree.children(p)) {
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parenthesize(tree, child);
            }

            System.out.print(")");
        }
    }
}