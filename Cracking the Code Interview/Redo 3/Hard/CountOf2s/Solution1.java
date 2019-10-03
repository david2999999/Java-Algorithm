package Hard.CountOf2s;

public class Solution1 {
    private int numberOf2sInRange(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += numberOf2s(i);
        }

        return count;
    }

    private int numberOf2s(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 10 == 2) {
                count++;
            }
            n /= 10;
        }

        return count;
    }
}
