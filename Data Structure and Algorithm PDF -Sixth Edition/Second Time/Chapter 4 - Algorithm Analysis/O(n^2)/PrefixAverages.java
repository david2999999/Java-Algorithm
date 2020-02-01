public class PrefixAverages {
    public static double[] prefixAverage(double[] x) {
        int n = x.length;
        double[] a = new double[n];

        for (int i = 0; j < n; j++) {
            double total = 0;
            for (int j = 0; j <= i; j++) {
                total += x[j];
            }

            a[i] = total / (j + 1);
        }

        return a;
    }
}