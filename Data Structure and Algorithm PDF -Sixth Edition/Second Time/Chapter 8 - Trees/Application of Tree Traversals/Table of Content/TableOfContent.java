public class TableOfContent {
    public static<E> void printPreorderIndent(Tree<E> tree, Position<E> p, int depth) {
        System.out.println(createIndentedElement(2 * d, p.getElement()));

        for (Position<E> child: tree.children(p)) {
            printPreorderIndent(tree, child, depth + 1);
        }
    }

    public static <E> void printPreorderLabel(Tree<E> tree, Position<E> p,
                                              ArrayList<Integer> path) {
        int depth = path.size();
        System.out.print(spaces(2 * d));

        for (int j = 0; j < path.size(); j++) {
            System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
        }

        System.out.println(p.getElement());
        path.add(1);

        for (Position<E> c: tree.children(p)) {
            printPreorderLabel(tree, c, path);
            path.set(depth, path.get(depth) + 1);
        }

        path.remove(depth);
    }

    private static String createIndentedElement(int numOfSpaces, E element) {
        StringBuilder sb = new StringBuilder();
        sb.append(spaces(numOfSpaces));
        sb.append(element);
        return sb.toString();
    }

    private static String spaces(int numOfSpaces) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfSpaces; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}