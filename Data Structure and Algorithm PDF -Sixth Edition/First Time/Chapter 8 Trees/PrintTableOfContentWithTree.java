public class PrintTableOfContentWithTree {
     public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement());
        for (Position<E> c: T.children(p))
            printPreorderIndent(T, c, d + 1);
    }
    
    public static <E> void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
        int d = path.size();
        System.out.print(spaces(2 * d));
        for (int i = 0; i < d; i++) {
            System.out.print(path.get(i) + (i == d - 1 ? " " : "."));
        }
        
        System.out.print(p.getElement());
        path.add(1);
        for (Position<E> c: T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
        }
        
        path.remove(d);
    }
    
    private static String spaces(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(' ');
        }
        
        return sb.toString();
    } 
}