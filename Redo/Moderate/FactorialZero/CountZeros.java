package Redo.Moderate.FactorialZero;

public class CountZeros {
    private int factorsOf5(int num) {
        int count = 0;

        while (num % 5 == 0) {
            count++;
            num /= 5;
        }

        return count;
    }

    private int count(int num) {
        int count = 0;

        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }

        return count;
    }



}
