public class TestCollections {
    public static void main(String[] args) {
        List g8 = new ArrayList();
        Collections.addAll(g8, "US", "DE", "JP", "FR", "GB", "RU", "CA", "IT");
        System.out.println(g8);
        Collections.swap(g8, 2, 4);
        System.out.println(g8);
        Collections.sort(g8);
        System.out.println(g8);
        int k = Collections.binarySearch(g8, "CN");
        System.out.println(k);
        if (k < 0) {
        g8.add(-k - 1, "CN");
        };
        System.out.println(g8);
        Collections.reverse(g8);
        System.out.println(g8);
    }
}