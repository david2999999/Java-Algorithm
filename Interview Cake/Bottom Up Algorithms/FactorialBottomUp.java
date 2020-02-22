public class FactorialBottomUp {
    public int product1ToN(int n) {
        int result = 1;

        for (int num = 1; num <= n; num++) {
            result *= num;
        }

        return result;
    }
}