int mean(int[] a) {
    double sum=0.0;
    for (int i = 0; i < a.length; i++) {
        sum += a[i];
    }
    
    return sum/a.length;
}