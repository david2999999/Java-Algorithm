public class TestSieve {
    private static final int SIZE=1000;
    private static BitSet isPrime = new BitSet(SIZE);
    
    public static void main(String[] args) {
        initializeSieve();
        ch02.pr20.TestSieve.printSieve();
    }
    
    private static void initializeSieve() {
        for (int i = 2; i < SIZE; i++) {
            isPrime.set(i);
        }
        
        for (int n = 2; 2*n < SIZE; n++) {
            if (isPrime.get(n)) {
                for (int m = n; m*n <SIZE; m++) {
                    isPrime.clear(m*n);
                }
            }
        }
    }
    
    private static void printSieve() {
        int n=0;
        for (int i = 0; i < SIZE; i++) {
            if (isPrime.get(i)) {
                System.out.printf("%5d%s", i, ++n%16==0?"\n":"");
            }
        }
        System.out.printf("%n%d primes less than %d%n", n, SIZE);
    }
}