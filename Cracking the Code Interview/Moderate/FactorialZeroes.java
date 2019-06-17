package Moderate;

public class FactorialZeroes {
    private int countFactZeros(int num) {
        int count = 0;

        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }

        return count;
    }

    private int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }

        return count;
    }
}
