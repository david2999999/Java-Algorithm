double[][] outerProduct(double[] x, double[] y) {
    double[][] z = new double[x.length][y.length];
    for (double xi : x) {
        for (double yj : y) {
            z[i][j] = xi*yj;
        }
    }
    return z;
}