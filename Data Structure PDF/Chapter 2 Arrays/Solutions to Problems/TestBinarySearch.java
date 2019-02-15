public class TestBinarySearch {
    private static final int SIZE = 10000;
    private static final int START = 0;
    private static final int RANGE = 10000;
    private static Random random = new Random();
    private static int count = 0;
    
    public static void main(String[] args) {
        int[] a = new int[SIZE];
        load(a, START, RANGE);
        Arrays.sort(a);
        search(a, random.nextInt(10000));
        System.out.println(count + " iterations");
    }
    
    public static void load(int[] a, int start, int range) {
        for (int i = 0; i < a.length; i++) {
            a[i] = start + random.nextInt(range); // random 5-digit numbers
        }
    }
    public static int search(int[] a, int x) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            ++count;
            int i = (lo + hi)/2;
            
            if (a[i] == x) {
                return i;
            } else if (a[i] < x) {
                lo = i+1;
            } else {
                hi = i;
            }
        }
        return -1;
    }
}