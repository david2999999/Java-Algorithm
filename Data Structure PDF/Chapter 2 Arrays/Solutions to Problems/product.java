double[][] product(double[][] x, double[][] y) {
    double[][] z = new double[x.length][y[0].length];
    for (int i = 0; i < x.length; i++) {
        for (int j = 0; j < y[0].length; j++) {
            double sum = 0.0;
        
            for (int k = 0; k < x[0].length; k++) {
                sum += x[i][k]*y[k][j];
            }
        
            z[i][j] = sum;
        }
    }
    return z;
}