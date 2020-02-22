public class Factorial {
    public int product1ToN(int n) {
        return (n > 1) ? (n * product1ToN(n - 1)) : 1;
    }
}