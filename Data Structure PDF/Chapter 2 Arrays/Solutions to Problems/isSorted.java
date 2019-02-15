boolean isSorted(int[] a) {
    if (a.length < 2) {
        return true;
    }
    for (int i = 1; i < a.length; i++) {
        if (a[i] < a[i-1]) {
            return false;
        }
    }
    return true;
}