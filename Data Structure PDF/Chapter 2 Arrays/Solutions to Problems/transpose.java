double[][] transpose(double[][] x) {
    double[][] y = new double[x[0].length][x.length];
    for (int i = 0; i < x[0].length; i++) {
        for (int j = 0; j < x.length; j++) {
            y[i][j] = x[j][i];
        }
    }
    return y;
}