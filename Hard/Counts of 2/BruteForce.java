package Hard.Count2s;

public class BruteForce {
    public int numberOf2sInRange(int n) {
        int count = 0;

        for (int i = 0; i <= n; i++) {
            count += numberOf2s(i);
        }

        return count;
    }

    private int numberOf2s(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 10 == 2)
                count++;

            n = n / 10;
        }

        return count;
    }
}
