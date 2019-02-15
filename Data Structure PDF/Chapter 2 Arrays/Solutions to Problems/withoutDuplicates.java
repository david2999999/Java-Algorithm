int[] withoutDuplicates(int[] a) {
    int n = a.length;
    
    if (n < 2) {
        return a;
    }
    for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j < n; j++) {
            if (a[j] == a[i]) {
                --n;
                System.arraycopy(a, j+1, a, j, n-j);
                --j;
            }
        }
    }
    int[] aa = new int[n];
    System.arraycopy(a, 0, aa, 0, n);
    return aa;
}