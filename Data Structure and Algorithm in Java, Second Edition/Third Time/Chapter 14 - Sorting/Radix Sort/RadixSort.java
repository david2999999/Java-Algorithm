public class RadixSort {
    private static final int WIDTH = 10;
    private static final int RADIX = 10;

    public void sort(int[] arr) {
        for (int digit = 0; digit < WIDTH; digit++) {
            sort(arr, digit);
        }
    }

    public void sort(int[] arr, int digit) {
        int length = arr.length;
        int[] radixCount = new int[RADIX];

        for (int num: arr) {
            ++radixCount[digit(digit, num)];
        }

        for (int j = 1; j < RADIX; j++) {
            radixCount[j] += radixCount[j - 1];
        }

        int[] temp = new int[length];
        for (int i = n - 1; i >= 0; i++) {
            temp[--radixCount[digit, a[i]]] = a[i];
        }

        for (int i = 0; i < length; i++) {
            arr[i] = temp[i];
        }
    }

    private int digit(int digit, int num) {
        return (num / (int) Math.pow(10, digit)) % RADIX;
    }
}