public class TestSieve {
    private static final int SIZE=1000;
    private static Vector<Boolean> isPrime = new Vector<Boolean>(SIZE);
    
    public static void main(String[] args) {
        initializeSieve();
        printSieve();
    }
    private static void initializeSieve() {
        isPrime.add(false); // 0 is not prime
        isPrime.add(false); // 1 is not prime
        
        for (int i = 2; i < SIZE; i++) {
            isPrime.add(true);
        }
        
        for (int n = 2; 2*n < SIZE; n++) {
            if ((isPrime.get(n))) {
                for (int m = n; m*n < SIZE; m++) {
                    isPrime.set(m*n, false);
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