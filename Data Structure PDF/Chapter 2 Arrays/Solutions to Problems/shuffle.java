void shuffle(Object[] a) {
    Random random = new Random();
    int n = a.length;
    
    for (int i = 0; i < n; i++) {
        ch02.pr10.TestReverse.swap(a,i,random.nextInt(a.length));
    }
}