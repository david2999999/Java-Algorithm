package Hard.RandomSet;

public class RandomSetRecursively {
    private int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    public int[] pickRecursively(int[] original, int m, int i) {
        if ( i + 1 == m) {
            // return first m elements of original
        } else if (i + 1 > m) {
            int[] subset = pickRecursively(original, m, i - 1);
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
            return subset;
        }

        return null;
    }
}
