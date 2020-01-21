public class Fibonacci {
    public int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;

        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}

// The root node has two children. Each of those children has two children (so four children total in the "grandchildren"
//level). Each of those grandchildren has two children, and so on. If we do this n times, we'll have
//roughly O( 2") nodes. This gives us a runtime of roughly 0( 2").