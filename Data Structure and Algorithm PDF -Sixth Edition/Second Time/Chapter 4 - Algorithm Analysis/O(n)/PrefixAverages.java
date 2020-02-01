public class PrefixAverages {
    public static double[] prefixAverage(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            total += x[i];
            a[i] = total / (i + 1);
        }

        return a;
    }
}