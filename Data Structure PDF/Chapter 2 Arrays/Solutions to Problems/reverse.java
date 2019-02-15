void reverse(int[] a) {
    int n = a.length;
    if (n < 2) {
        return;
    }
    
    for (int i = 0; i < n/2; i++) {
        swap(a, i, n-i-1);
    }
}
void swap(int[] a, int i, int j) {
    // swaps a[i] with a[j]:
    int ai = a[i];
    int aj = a[j];
    a[i] = aj;
    a[j] = ai;
}