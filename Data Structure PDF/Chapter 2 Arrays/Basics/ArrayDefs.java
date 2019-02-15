public class ArrayDefs {
    public static void main(String[] args) {
        float x[];
        x = new float[100];
        args = new String[10];
        boolean[] isPrime = new boolean[1000];
        int fib[] = {0, 1, 1, 2, 3, 5, 8, 13};
        short[][][] b = new short[4][10][5];
        double a[][] = {{1.1,2.2}, {3.3,4.4}, null, {5.5,6.6}, null};
        a[4] = new double[66];
        a[4][65] = 3.14;
        Object[] objects = {x, args, isPrime, fib, b, a};
    }
}