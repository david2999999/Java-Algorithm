public class DiskSpace {
    public static int diskSpace(Tree<Integer> tree, Position<Integer> p) {
        int subtotal = p.getElement();
        for (Position<Integer> c: tree.children(p)) {
            subtotal += diskSpace(c);
        }

        return subtotal;
    }
}