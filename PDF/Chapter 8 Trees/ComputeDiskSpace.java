public class ComputeDiskSpace {
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement();
        for (Position<Integer> c: T.children(p)) {
            subtotal += diskSpace(T, c);
        }
        
        return subtotal;
    }
}