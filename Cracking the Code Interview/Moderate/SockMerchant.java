package Interview;

import java.util.HashMap;

public class SockMerchant {
    public static void main(String[] args) {
        int[] arr = {10 ,20 ,20 ,10 ,10 ,30 ,50 ,10 ,20};
        int n = 9;

        System.out.println(findPairs(n, arr));
    }
    private static int findPairs(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalPair = 0;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(ar[i])) {
                map.put(ar[i], 0);
            }

            map.put(ar[i], map.get(ar[i]) + 1);
        }

        for (Integer key: map.keySet()) {
            while (map.get(key) > 1) {
                totalPair++;
                map.put(key, map.get(key) - 2);
            }
        }

        return totalPair;
    }
}
