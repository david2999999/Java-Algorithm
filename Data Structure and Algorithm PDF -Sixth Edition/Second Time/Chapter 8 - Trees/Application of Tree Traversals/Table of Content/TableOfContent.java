public class TableOfContent {
    public static<E> void printPreorderIndent(Tree<E> tree, Position<E> p, int depth) {
        System.out.println(createIndentedElement(2 * d, p.getElement()));

        for (Position<E> child: tree.children(p)) {
            printPreorderIndent(tree, child, depth + 1);
        }
    }

    private static String createIndentedElement(int numOfSpaces, E element) {
        StringBuilder sb = new StringBuilder();

        while (numOfSpaces > 0) {
            numOfSpaces--;
            sb.append(" ");
        }

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