public class GenericMethod {
    public static void main(String[] args) {
        args = new String[]{"CA", "US", "MX", "HN", "GT"};
        print(args);
    }

    static <E> void print(E[] a) {
        for (E ae : a) {
            System.out.printf("%s ", ae);
        }
        System.out.println();
    }
}