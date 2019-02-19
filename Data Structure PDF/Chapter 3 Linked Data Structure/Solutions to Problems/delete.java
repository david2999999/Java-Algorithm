void delete(int[] a, int n, int x) {
    int i = 0; // find the first index i for which a[i] > x:
    
    while (i < n && a[i] <= x) {
        ++i;
    }
    
    if (i < n-1) {
        System.arraycopy(a, i, a, i-1, n-i);
    }
    a[n-1] = 0;
}