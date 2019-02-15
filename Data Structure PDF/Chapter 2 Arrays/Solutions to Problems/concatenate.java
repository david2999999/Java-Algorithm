Object[] concatenate(Object[] a, Object[] b) {
    Object[] c = new Object[a.length+b.length];
    for (int i = 0; i < a.length; i++) {
        c[i] = a[i];
    }
    
    for (int i = 0; i < b.length; i++) {
        c[i+a.length] = b[i];
    }
    return c;
}