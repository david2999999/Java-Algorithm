package Moderate;

public class FactorialZeroesEfficient {
    private int countFactZeros(int num) {
        if (num < 0) return -1;

        int count = 0;
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }

        return count;
    }
}
