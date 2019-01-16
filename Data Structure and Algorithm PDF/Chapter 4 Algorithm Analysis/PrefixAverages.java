public class PrefixAverages {
    // The running time of implementation prefixAverage1 is given by the sum of these
    // terms. The first term is O(1), the second and third terms are O(n), and the fourth
    // term is O(n2). By a simple application of Proposition 4.8, the running time of
    // prefixAverage1 is O(n2).
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++) 
                total += x[i];
            a[j] = total / (j + 1);
        }
        
        return a;
    }
    
    // The running time of algorithm prefixAverage2 is given by the sum of the five terms.
    // The first and last are O(1) and the remaining three are O(n). By a simple application
    // of Proposition 4.8, the running time of prefixAverage2 is O(n), which is much
    // better than the quadratic time of algorithm prefixAverage1.
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }
}