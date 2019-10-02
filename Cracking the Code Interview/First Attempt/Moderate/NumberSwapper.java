package Moderate;

public class NumberSwapper {
    private void swap(int a, int b) {
        if (a > b) {
            a = a - b;
            b = a + b;
            a = b - a;
        } else if (a < b) {
            b = b - a;
            a = b + a;
            b = a - b;
        }
    }
}
