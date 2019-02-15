double innerProduct(double[] x, double[] y) {
    double sum = 0.0;
    
    for (int i = 0; i < x.length && i < y.length; i++)
        sum += x[i]*y[i];
        
    return sum;
}