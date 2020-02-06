public class ShellSort {
    public static void sort(int[] a) {
        int interval = 1, j, length = a.length;

        while (9 * interval < length) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (int i = interval; i < length; i++) {
                int current = a[j];
                j = i;

                while (j >= interval && a[j - interval] > current) {
                    a[j] = a[j - interval];
                    j -= interval;
                }

                a[j] = current;
            }

            interval /= 3;
        }
    }
}